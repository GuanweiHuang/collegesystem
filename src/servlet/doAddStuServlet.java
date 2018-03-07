package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.StuService;
import emtity.student;

/**
 * Servlet implementation class doAddStuServlet
 */
@WebServlet("/doAddStuServlet")
public class doAddStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public doAddStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String no = request.getParameter("userNo");
		String pwd = request.getParameter("userpwd");
		String name = request.getParameter("userName");
		int nage = Integer.parseInt(request.getParameter("userAge"));
		String nsex = request.getParameter("userSex");
		String nadd = request.getParameter("userAdd");
		String nphone = request.getParameter("userPhone");
		String nbirth = request.getParameter("userbirth");
		String nation = request.getParameter("usernation");
		String npolt  = request.getParameter("userpolt");
		int course = Integer.parseInt(request.getParameter("usercourse"));
		int tbclass = Integer.parseInt(request.getParameter("userClass"));
		int userTea = Integer.parseInt(request.getParameter("userTea"));
		
		student stu = new student(0,no,name,nage,nsex,pwd,nadd,nphone,nbirth,nation,npolt,tbclass,course,userTea);
		PrintWriter out = response.getWriter();
		if(new StuService().addStu(stu)){
			out.print("<h2 style='font-family:Î¢ÈíÑÅºÚ'>Ñ§ÉúÌí¼Ó³É¹¦£¡</h2>");
		}else{
			out.print("<h2 style='font-family:Î¢ÈíÑÅºÚ'>Ñ§ÉúÌí¼ÓÊ§°Ü£¡</h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
