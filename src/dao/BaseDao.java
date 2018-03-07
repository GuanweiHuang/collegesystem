package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * �������ݿ�Ļ�����
 */
public class BaseDao {
	
	static{
		/*
		 * ��������
		 */
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
		/*
		 * ��ȡ�������ݿ�Ĺ������ӷ���
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
	 * �ر����ݿ⣬�ͷ���Դ
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
	 * ������ִ�ж����ݿ���ӣ�ɾ�����޸ĵķ���
	 * @param sql Ҫִ�е�SQL��䣬֧��ռλ��
	 * @param obj ���SQL��ռλ����ͨ��obj���鴫��ռλ����Ӧ������
	 * @return
	 */
	public static boolean updateDb(String sql,Object[] obj){
		Connection conn=getConnection();//��ȡ���ݿ�����
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);//����һ��Ԥ����������
			//���������ռλ����Ӧ��ֵ����˵��ʹ����ռλ��
			if(obj!=null&&obj.length>0){
				for (int i = 0; i < obj.length; i++) {
					ps.setObject(i+1, obj[i]);
				}
			}
			if(ps.executeUpdate()>0)//ִ���޸�
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB(conn, ps, null);
		}
		return false;
	}
	
}

