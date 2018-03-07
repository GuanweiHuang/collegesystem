package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StuDao;
import emtity.dissent;

/**
 * Servlet implementation class dissentServlet
 */
@WebServlet("/dissentServlet")
public class dissentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public dissentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����Ϣ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String dlei = request.getParameter("dlei");		
		String dstime = request.getParameter("dstime");
		int entno = Integer.parseInt(request.getParameter("entno"));
		String stuno = request.getParameter("stuno");
		String dsname = request.getParameter("dsname");
		//��װ��������
		dissent dis = new dissent(0,dsname,dlei,dstime,entno,stuno);
		PrintWriter out = response.getWriter();
		//����dao��
		if(new StuDao().adddissent(dis)){
			out.println("<h2>���ͳɹ���</h2>");
		}else{
			out.println("<h2>����ʧ�ܣ�</h2>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
