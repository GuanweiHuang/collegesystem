package service;

import java.util.List;

import dao.teacharDao;
import emtity.student;

public class StuService {
		//���ѧ��
	public boolean addStu(student stu){
		//��ѧ�������һ������
		new teacharDao().addStu(stu);
		//�����ڰ༶������1
		//����Ҫ����������ݿ������class��
		String sql = "update stuclass set cnumber=cnumber+1 where cno="+stu.getSclass()+"";
		new teacharDao().updateTbClass(sql);
		return true;
	}
	
	//��ѯ������δ���İ༶
	public List getNoFullClass(){
		String sql ="select * from stuclass where cnumber<=30";
		return new teacharDao().getClasslist(sql);
	}
	
	//��ѯ��ȫ���༶
	public List getClassList(){
		String sql="select * from stuclass";
		return new teacharDao().getClasslist(sql);
	}
	
	
}
