package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emtity.dissent;
import emtity.student;




public class StuDao {
	public List getUserlist(String userName,String pwd){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from student where sname='"+userName+"'");
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				student stu = new student();
				String sname=rs.getString(2);
				String spwd=rs.getString(6);
				if(spwd.equals(pwd)&&sname.equals(sname)){
					stu.setSno(rs.getInt(1));
					stu.setSname(sname);
					stu.setSauthor(rs.getString(3));
					stu.setSage(rs.getInt(4));
					stu.setSsex(rs.getString(5));
					stu.setSpwd(spwd);
					stu.setSaddresss(rs.getString(7));
					stu.setSphone(rs.getString(8));
					stu.setSbirth(rs.getString(9));
					stu.setsNation(rs.getString(10));
					stu.setSpolitic(rs.getString(11));
					stu.setSclass(rs.getInt(12));
					stu.setSstucourse(rs.getInt(13));
					stu.setTeacher(rs.getInt(14));
					list.add(stu);
					return list;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}

	//查询学生是哪个教员信息
	public List gettealist(String author){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
	String sql="select s.sauthor,c.cname,tt.tname,tt.tphone from stuclass c,student s,testr tt where c.cno=s.sclass and c.ctea=tt.tno and sname='"+author+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				String res[]=new String[4];
				for(int i=0;i<res.length;i++){
					res[i]=rs.getString(i+1);
				}
				list.add(res);
			}
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//查询学生所读课程
	public List getcournamelist(String stucourse){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		String sql="select s.sauthor,c.courname,c.credit,xt.tname from stucourse c,student s,testr xt where c.kno=s.sstucourse and c.cteaer=xt.tno and s.sname='"+stucourse+"'";  
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				String res[]=new String[4];
				for (int i = 0; i < res.length; i++) {
					res[i]=rs.getString(i+1);
				}
					list.add(res);
			}
					return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//根据用户名查询信息
		public student getgerenlist(String id){
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				ps = conn.prepareStatement("select * from student where sno='"+id+"'");
				rs = ps.executeQuery();
				while(rs.next()){
					student stu = new student();
						stu.setSno(rs.getInt(1));
						stu.setSauthor(rs.getString(3));
						stu.setSsex(rs.getString(5));
						stu.setSage(rs.getInt(4));
						stu.setSaddresss(rs.getString(7));
						stu.setSphone(rs.getString(8));
						stu.setsNation(rs.getString(10));
						stu.setSpolitic(rs.getString(11));
						return stu;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeDB(conn, ps, rs);
			}
				return null;
		}
		/**
		 * 修改学生
		 * @param stu 封装了所有学生信息的对象
		 * @return
		 */
		public boolean updateStu(student stu){
			String sql="update student set sauthor=?,ssex=?,sage=?,saddresss=?,sphone=?,sNation=?,spolitic=? where sno=?";
			Object[] obj={stu.getSauthor(),stu.getSsex(),stu.getSage(),stu.getSaddresss(),stu.getSphone(),stu.getsNation(),stu.getSpolitic(),stu.getSno()};
			return BaseDao.updateDb(sql, obj);
		}
		
		/***
		 * 删除学生
		 * 根据编号删除学生
		 * @param stu 用户编号
		 * @return 
		 */
		public boolean deleteStu(int sno){
			String sql="delete student where sno="+sno;
			return BaseDao.updateDb(sql, null);
		}
		
		//发送消息
		public boolean adddissent(dissent dis){
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = null;
			try {
				String sql="insert into dissent values(?,?,?,?,?)";
				ps=conn.prepareStatement(sql);
				ps.setString(1, dis.getDsname());
				ps.setString(2, dis.getDlei());
				ps.setString(3, dis.getDstime());
				ps.setInt(4, dis.getEntno());
				ps.setString(5, dis.getStuno());
				if(ps.executeUpdate()>0){
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeDB(conn, ps, null);
			}
				return false;
		}
		
		//查询消息
		public List getdissentlist(String disname){
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				String sql="select ds.dsname,ds.dlei,ds.dstime,ds.stuno,tt.tname from dissent ds,testr tt where ds.entno=tt.tno and tt.tauthor='"+disname+"'";
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				List list = new ArrayList();
				while(rs.next()){
					String[] res=new String[5];
					for(int i=0;i<res.length;i++){
						res[i]=rs.getString(i+1);
					}
						list.add(res);
				}
						return list;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				BaseDao.closeDB(conn, ps, rs);
			}
				return null;
		}
}
