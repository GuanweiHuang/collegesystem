package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 连接数据库的基础类
 */
public class BaseDao {
	
	static{
		/*
		 * 加载驱动
		 */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		/*
		 * 获取连接数据库的公共连接方法
		 */
	public static Connection getConnection(){
		String jdbcUrl="jdbc:sqlserver://localhost:1433;databaseName=collegesystem";
		try {
			return DriverManager.getConnection(jdbcUrl,"sa","123456");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * 关闭数据库，释放资源
	 */
	public static void closeDB(Connection conn,Statement st,ResultSet rs){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 公共的执行对数据库添加，删除，修改的方法
	 * @param sql 要执行的SQL语句，支持占位符
	 * @param obj 如果SQL有占位符，通过obj数组传递占位符对应的数据
	 * @return
	 */
	public static boolean updateDb(String sql,Object[] obj){
		Connection conn=getConnection();//获取数据库链接
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);//构建一个预编译语句对象
			//如果传递了占位符对应的值，则说明使用了占位符
			if(obj!=null&&obj.length>0){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			if(ps.executeUpdate()>0)//执行修改
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB(conn, ps, null);
		}
		return false;
	}
	
}

