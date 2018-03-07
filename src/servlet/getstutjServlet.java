package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.teaService;

/**
 * Servlet implementation class getstutjServlet
 */
@WebServlet("/getstutjServlet")
public class getstutjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public getstutjServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("uname");
		String banji = request.getParameter("banji");
		//封装到数据里面去
		String[] query={name,banji};
		//调用服务层方法查询
		List list = new teaService().getstutjlist(query);
		request.setAttribute("stutjlist", list);
		request.getRequestDispatcher("teakeche.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
