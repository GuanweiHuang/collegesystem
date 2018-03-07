package dao;


/*
 * 修改密码
 */
public class doUpdatePasswordDao {
	//修改学生密码dao
	public boolean UpdatePassword(String password,String userName ){
		String sql="update student set spwd='"+password+"' where sname='"+userName+"'";
		return BaseDao.updateDb(sql, null);
	}
	//修改教师密码dao
	public boolean UpdateTeaPassword(String password,String aname ){
		String sql="update testr set tpwd='"+password+"' where tauthor='"+aname+"'";
		return BaseDao.updateDb(sql, null);
	}
}
