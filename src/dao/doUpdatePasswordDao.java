package dao;


/*
 * �޸�����
 */
public class doUpdatePasswordDao {
	//�޸�ѧ������dao
	public boolean UpdatePassword(String password,String userName ){
		String sql="update student set spwd='"+password+"' where sname='"+userName+"'";
		return BaseDao.updateDb(sql, null);
	}
	//�޸Ľ�ʦ����dao
	public boolean UpdateTeaPassword(String password,String aname ){
		String sql="update testr set tpwd='"+password+"' where tauthor='"+aname+"'";
		return BaseDao.updateDb(sql, null);
	}
}
