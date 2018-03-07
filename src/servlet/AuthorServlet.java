package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.StuDao;

/**
 * Servlet implementation class AuthorServlet
 */
@WebServlet("/AuthorServlet")
public class AuthorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthorServlet() {
        super();
        
    }
    /*
     * 显示个人信息
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取出登录用户信息 
		HttpSession session = request.getSession();		
		String userName = (String)session.getAttribute("userName");
		String userPwd  = (String)session.getAttribute("userPwd");
		//调用后台方法验证登录
		List list = new StuDao().getUserlist(userName,userPwd);
		if(list==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('查找失败！');history.back();</script>");
			out.close();
		}else{
			request.setAttribute("authorList",list);
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
