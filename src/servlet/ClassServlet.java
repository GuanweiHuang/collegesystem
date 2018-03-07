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
 * Servlet implementation class ClassServlet
 */
@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ClassServlet() {
        super();
        
    }
    //查询班级信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取出登录用户信息
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		
		//调用后台方法查询信息
		List list = new StuDao().gettealist(userName);
		if(list==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('查找失败！');history.back();</script>");
			out.close();
		}else{
			request.setAttribute("classlist", list);
			request.getRequestDispatcher("Class.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
