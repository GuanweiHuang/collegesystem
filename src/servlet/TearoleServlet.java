package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.teacharDao;

/**
 * Servlet implementation class TearoleServlet
 */
@WebServlet("/TearoleServlet")
public class TearoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TearoleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ȡ���������еĵ�¼�û�����
		HttpSession session = request.getSession();	
		String sname=(String)session.getAttribute("name");
		
		//��ֵ�����ѯ������ȥ��ѯ��
		List tearole =new teacharDao().gettearole(sname);
		
		//�Ѳ�ѯ�����Ľ�����浽��������
		request.setAttribute("tearole", tearole);
		//ת���ĵ�jspȥ��ʾ���ݡ�
		request.getRequestDispatcher("tearole.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
