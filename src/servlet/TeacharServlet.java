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

import dao.teacharDao;
import emtity.teachar;

/**
 * Servlet implementation class TeacharServlet
 */
@WebServlet("/TeacharServlet")
public class TeacharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeacharServlet() {
        super();
        
    }
    /**
     * 1:接收用户登录请求中传递的用户名和密码
     * 2:调用后台方法验证用户名和密码是否正确
     * 3:登录成功，去到index.jsp显示这个用户的所有信息，如果失败，提出提示返回登录页
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取出登录信息
		String name = request.getParameter("aname");
		String pwd  = request.getParameter("apwd");
		HttpSession session=request.getSession();
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", name);
		//调用后台方法验证登录
		List list = new teacharDao().checklogtea(name,pwd);
		if(list==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('登录失败!');history.back();</script>");
		}else{
			request.setAttribute("tealist",list);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
