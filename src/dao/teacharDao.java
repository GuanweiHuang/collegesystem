package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import emtity.SMS;
import emtity.TbClass;
import emtity.Tearole;
import emtity.stucourse;
import emtity.student;
import emtity.teachar;

/*
 * //��ѯ��ʦ������Ϣ
 */
public class teacharDao {
	public List checklogtea(String userName,String pwd){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from testr where tauthor='"+userName+"'");
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				teachar tea = new teachar();
				String tauthor=rs.getString(8);
				String tpwd=rs.getString(9);
				if(tpwd.equals(pwd)&&tauthor.equals(tauthor)){
					tea.setTno(rs.getInt(1));
					tea.setTname(rs.getString(2));
					tea.setTage(rs.getInt(3));
					tea.setTsex(rs.getString(4));
					tea.setTpost(rs.getString(5));
					tea.setTaddress(rs.getString(6));
					tea.setTphone(rs.getString(7));
					list.add(tea);
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

		
		//��ѯ��ʦ�༶��Ϣ
	public List getbanjilist(String classname){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql="select s.sno,s.sauthor,s.ssex,s.sage,s.saddresss,s.sphone,s.sNation,s.spolitic,c.cname from  stuclass c,student s,testr tr where c.cno=s.sclass and c.ctea=tr.tno and tr.tauthor='"+classname+"'";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				String[] res = new String[9];
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
	
	//Ϊ�༶����µ�ѧ��
	public boolean addStu(student stu){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		try {
			String sql="insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
		    ps.setString(2, stu.getSauthor());
		    ps.setInt(3, stu.getSage());
		    ps.setString(4, stu.getSsex());
		    ps.setString(5, stu.getSpwd());
		    ps.setString(6, stu.getSaddresss());
		    ps.setString(7, stu.getSphone());
		    ps.setString(8, stu.getSbirth());
		    ps.setString(9, stu.getsNation());
		    ps.setString(10,stu.getSpolitic());
		    ps.setInt(11, stu.getSclass());
		    ps.setInt(12, stu.getSstucourse());
		    ps.setInt(13, stu.getTeacher());
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
	
	//�����ڰ༶���ѧ��
	public boolean updateTbClass(String sql){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
	
	//��ѯ���а༶���������
	public List getClasslist(String sql){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				TbClass cls = new TbClass();
				cls.setCno(rs.getInt(1));
				cls.setCname(rs.getString(2));
				cls.setCnumber(rs.getInt(3));
				cls.setCtea(rs.getInt(4));
				list.add(cls);
			}
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//��ѯ�����еĿγ�
	public List getstucourselist(){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from stucourse");
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				stucourse stuse = new stucourse();
				stuse.setKno(rs.getInt(1));
				stuse.setCourname(rs.getString(2));
				stuse.setCteaer(rs.getInt(3));
				list.add(stuse);
			}
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//��ѯ���е���ʦ
	public List gettealist(){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from testr");
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				teachar tea = new teachar();
				tea.setTno(rs.getInt(1));
				tea.setTname(rs.getString(2));
				tea.setTage(rs.getInt(3));
				tea.setTsex(rs.getString(4));
				tea.setTpost(rs.getString(5));
				tea.setTaddress(rs.getString(6));
				tea.setTphone(rs.getString(7));
				tea.setTauthor(rs.getString(8));
				tea.setTpwd(rs.getString(9));
				list.add(tea);
			}
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//����ѧ����Ų�ѯ����
	public student getStuById(int id){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql="select * from student where sno="+id;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				student stu = new student();
				stu.setSno(rs.getInt(1));
				stu.setSname(rs.getString(2));
				stu.setSauthor(rs.getString(3));
				stu.setSage(rs.getInt(4));
				stu.setSsex(rs.getString(5));
				stu.setSpwd(rs.getString(6));
				stu.setSaddresss(rs.getString(7));
				stu.setSphone(rs.getString(8));
				stu.setSbirth(rs.getString(9));
				stu.setsNation(rs.getString(10));
				stu.setSpolitic(rs.getString(11));
				stu.setSclass(rs.getInt(12));
				stu.setSstucourse(rs.getInt(13));
				stu.setTeacher(rs.getInt(14));
				return stu;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	/*
	 * ����������ѯѧ������Ϣ
	 */
	public List getstutjlist(String sql){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				String res[]=new String[6];
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
	
	/*
	 * ��ѯ����Ϣ
	 */
	public List getSMSlist(){
		Connection conn = BaseDao.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("select * from SMS");
			rs = ps.executeQuery();
			List list = new ArrayList();
			while(rs.next()){
				SMS sms = new SMS();
				sms.setMno(rs.getInt(1));
				sms.setMname(rs.getString(2));
				sms.setMtime(rs.getString(3));
				list.add(sms);
			}
				return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			BaseDao.closeDB(conn, ps, rs);
		}
			return null;
	}
	
	//��ѯ����ʦ��ְ�ơ�
	
		public List gettearole(String sname){
			Connection conn = BaseDao.getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				//���ݴ��������û�������ѯ��
				String sql="select * from tearole where trotauthor="+sname;
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				//����һ�����϶���
				List list=new ArrayList();
				while(rs.next()){
					//�ŵ�ʵ������ȥ����
				  Tearole tro=new Tearole();
				  tro.setTroname(rs.getString(2));
	              tro.setTrole(rs.getString(4));
	              tro.setTroimages(rs.getString(5));
				  //�ѽ����ӵ��������ȥ��
	              list.add(tro);
				  
				}
				//���ؽ����
				return list;
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				//�ر����ݿ�
				BaseDao.closeDB(conn, ps, rs);
			}
				return null;
		}


}

