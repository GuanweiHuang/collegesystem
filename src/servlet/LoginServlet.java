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
import emtity.student;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
        
    }
    /**
     * 1:�����û���¼�����д��ݵ��û���������
     * 2:���ú�̨������֤�û����������Ƿ���ȷ
     * 3:��¼�ɹ���ȥ��index.jsp��ʾ����û���������Ϣ�����ʧ�ܣ������ʾ���ص�¼ҳ
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//ȡ����¼�û���Ϣ
		String userName = request.getParameter("userName"); //��¼�����û���ֵ
		String userPwd  = request.getParameter("userPwd");
		HttpSession session = request.getSession();			//��������
		session.setAttribute("userName", userName);			//�ѱ���ֵ���浽������
		session.setAttribute("userPwd", userPwd);
		//���ú�̨������֤��¼
		List list = new StuDao().getUserlist(userName,userPwd);
		if(list==null){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('��¼ʧ�ܣ�');history.back();</script>");
			out.close();
		}else{
			request.setAttribute("userList",list);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
