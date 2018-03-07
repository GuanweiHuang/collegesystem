package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;





import dao.doUpdatePasswordDao;

/**	�޸�����
 * Servlet implementation class doUpdatePasswordServlet
 */
@WebServlet("/doUpdatePasswordServlet")
public class doUpdatePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public doUpdatePasswordServlet() {
        super();
       
    }
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String opt=request.getParameter("opt");//�����û����ݵĲ��������ж�Ҫ���õķ���
    	if("UpdateStu".equals(opt)){
    		doUpdateStu(request, response);
    	}else if("UpdateTea".equals(opt)){
    		doUpdateTea(request, response);
    	}
    	
    }
    //ѧ���޸�����
	protected void doUpdateStu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newpass=request.getParameter("newpass");
		HttpSession session = request.getSession();
		String userName = (String)session.getAttribute("userName");
		new doUpdatePasswordDao().UpdatePassword(newpass,userName);
		PrintWriter out=response.getWriter();
		out.print(newpass);
		out.close();
	}
	//��ʦ�޸�����
	protected void doUpdateTea(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String newpass=request.getParameter("newpord");
		HttpSession session = request.getSession();
		String aname = (String)session.getAttribute("name");
		new doUpdatePasswordDao().UpdateTeaPassword(newpass, aname);
		PrintWriter out=response.getWriter();
		out.print(newpass);
		out.close();
		
	}

}
