package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.StuDao;
import emtity.student;

/**
 * Servlet implementation class UpdateStuServlet
 */
@WebServlet("/UpdateStuServlet")
public class UpdateStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateStuServlet() {
        super();
    }
    //�Զ�������ת������
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");
    	//�����������opt���ж��û�Ҫ�����ĸ�����
    	String opt=request.getParameter("opt");
    	switch(opt){
    		case "stuBySauthor":
    			findStuBySauthor(request, response);
    			break;
    		case "updateStu":
    			doUpdateStu(request, response);
    			break;
    		case "deleteStu":
    			doDeleteStu(request, response);
    	}
    }
  //�������ID����ѧ��������
	protected void findStuBySauthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno=request.getParameter("sno");
		//����Dao��������ѯ��ѧ������
		student classt = new StuDao().getgerenlist(sno);
		//�������JSON��ʽ��Ӧ���ͻ���
		PrintWriter out=response.getWriter();
		out.print(new Gson().toJson(classt));
		out.close();
	}

	protected void doUpdateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡ�����󴫵ݹ����Ĳ���
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sauthor=request.getParameter("sauthor");
		String sex=request.getParameter("ssex");
		int age=Integer.parseInt(request.getParameter("sage"));
		String saddresss=request.getParameter("saddresss");
		String sphone=request.getParameter("sphone");
		String sNation=request.getParameter("sNation");
		String poltic=request.getParameter("spolitic");
		//��װ���ݵ�ѧ����
		student stu=new student();
		stu.setSno(sno);
		stu.setSauthor(sauthor);
		stu.setSsex(sex);
		stu.setSage(age);
		stu.setSaddresss(saddresss);
		stu.setSphone(sphone);
		stu.setsNation(sNation);
		stu.setSpolitic(poltic);
		//����ѧ��Dao����ִ����Ӳ���
		PrintWriter out=response.getWriter();
		if(new StuDao().updateStu(stu)){
			out.println(1);
		}else{
			out.println(0);
		}
		out.close();
	}
	
	protected void doDeleteStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//ȡ��Ҫɾ���û��ı��
		int sno=Integer.parseInt(request.getParameter("sno"));
		
		//����ѧ��Dao����ִ��ɾ��
		PrintWriter out=response.getWriter();
		if(new StuDao().deleteStu(sno)){
			out.print(1);
		}else{
			out.print(0);
		}
		out.close();
	}
}
