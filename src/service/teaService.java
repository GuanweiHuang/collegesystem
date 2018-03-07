package service;

import java.util.List;

import dao.teacharDao;


public class teaService {
		//根据条件查询学生信息
	public List getstutjlist(String[] query){
	String sql="select s.sno,s.sauthor,sy.courname,sy.credit,ISNULL(m.cname,0)bj,tt.tname from student s,stuclass m,testr tt,stucourse sy where s.sclass=m.cno and m.ctea=tt.tno and sy.kno=s.sstucourse";
	//有筛选条件
	if(query!=null&&query.length>0){
		if(query[0]!=null&&query[0].length()>0){
			sql+=" and sauthor like '%"+query[0]+"%'";
		}
		if(query[1]!=null&&query[1].length()>0){
			sql+=" and cname like '%"+query[1]+"%'";
		}
	}
		return new teacharDao().getstutjlist(sql);
	}
}
