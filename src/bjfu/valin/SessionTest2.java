package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest2
 */
@WebServlet("/sessionTest2")
public class SessionTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
    		//��������
    		response.setContentType("text/html;charset=gbk");
    		
    		PrintWriter pw=response.getWriter();
    		//�õ���request�������session�����û�оʹ���session
    		HttpSession ht=request.getSession(true);
    		//�õ�session��id�����������������
    		String sessionID=ht.getId();
    		
    		pw.println("sessionTest2 ��session id ="+sessionID+"<br/>");
    		
    		//�õ�session��ĳ������
    		String myName=(String)ht.getAttribute("name");
    		pw.println("name="+myName);
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
