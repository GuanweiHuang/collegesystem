package service;

import java.util.List;

import dao.teacharDao;
import emtity.student;

public class StuService {
		//添加学生
	public boolean addStu(student stu){
		//向学生表添加一条数据
		new teacharDao().addStu(stu);
		//向所在班级人数加1
		//所以要创建相关数据库操作的class类
		String sql = "update stuclass set cnumber=cnumber+1 where cno="+stu.getSclass()+"";
		new teacharDao().updateTbClass(sql);
		return true;
	}
	
	//查询出人数未满的班级
	public List getNoFullClass(){
		String sql ="select * from stuclass where cnumber<=30";
		return new teacharDao().getClasslist(sql);
	}
	
	//查询出全部班级
	public List getClassList(){
		String sql="select * from stuclass";
		return new teacharDao().getClasslist(sql);
	}
	
	
}
