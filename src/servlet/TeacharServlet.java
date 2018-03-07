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
     * 1:�����û���¼�����д��ݵ��û���������
     * 2:���ú�̨������֤�û����������Ƿ���ȷ
     * 3:��¼�ɹ���ȥ��index.jsp��ʾ����û���������Ϣ�����ʧ�ܣ������ʾ���ص�¼ҳ
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ȡ����¼��Ϣ
		String name = request.getParameter("aname");
		String pwd  = request.getParameter("apwd");
		HttpSession session=request.getSession();
		session.setAttribute("pwd", pwd);
		session.setAttribute("name", name);
		//���ú�̨������֤��¼
		List list = new teacharDao().checklogtea(name,pwd);
		if(list==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('��¼ʧ��!');history.back();</script>");
		}else{
			request.setAttribute("tealist",list);
			request.getRequestDispatcher("index2.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
