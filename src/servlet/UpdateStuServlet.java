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
    //自定义请求转发规则
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html;charset=utf-8");
    	//接收请求参数opt，判断用户要调用哪个方法
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
  //处理根据ID查找学生的请求
	protected void findStuBySauthor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sno=request.getParameter("sno");
		//调用Dao方法，查询出学生对象
		student classt = new StuDao().getgerenlist(sno);
		//将结果以JSON格式响应到客户端
		PrintWriter out=response.getWriter();
		out.print(new Gson().toJson(classt));
		out.close();
	}

	protected void doUpdateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取出请求传递过来的参数
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sauthor=request.getParameter("sauthor");
		String sex=request.getParameter("ssex");
		int age=Integer.parseInt(request.getParameter("sage"));
		String saddresss=request.getParameter("saddresss");
		String sphone=request.getParameter("sphone");
		String sNation=request.getParameter("sNation");
		String poltic=request.getParameter("spolitic");
		//封装数据到学生中
		student stu=new student();
		stu.setSno(sno);
		stu.setSauthor(sauthor);
		stu.setSsex(sex);
		stu.setSage(age);
		stu.setSaddresss(saddresss);
		stu.setSphone(sphone);
		stu.setsNation(sNation);
		stu.setSpolitic(poltic);
		//调用学生Dao方法执行添加操作
		PrintWriter out=response.getWriter();
		if(new StuDao().updateStu(stu)){
			out.println(1);
		}else{
			out.println(0);
		}
		out.close();
	}
	
	protected void doDeleteStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取出要删除用户的编号
		int sno=Integer.parseInt(request.getParameter("sno"));
		
		//调用学生Dao方法执行删除
		PrintWriter out=response.getWriter();
		if(new StuDao().deleteStu(sno)){
			out.print(1);
		}else{
			out.print(0);
		}
		out.close();
	}
}
