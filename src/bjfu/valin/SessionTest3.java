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
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sessionTest3")
public class SessionTest3 extends HttpServlet { 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try{
    		//��������
    		response.setContentType("text/html;charset=gbk");
    		
    		PrintWriter pw=response.getWriter();
    		//�õ���request�������session�����û�оʹ���session
    		HttpSession ht=request.getSession(true);
    		//�õ�session��id�����������������
    		String sessionID=ht.getId();
    		
    		ht.setAttribute("test1", "����");
    		ht.setAttribute("test2", "����");
    		
    		pw.println("��û��ɾ��test1����ǰtest1="+ht.getAttribute("test1")+"<br/>");
    		//ɾ��session�е�test1������
    		ht.removeAttribute("test1");
    		//ɾ��ȫ��session������
    		//ht.setMaxInactiveInterval(0);�����������˷������ɹ�
    		pw.println("��ɾ��test1���Ժ�test1="+ht.getAttribute("test1")+"<br/>");
    		pw.println("��ɾ��test1���Ժ�test2="+ht.getAttribute("test2")+"<br/>");
    		
    		
    		pw.println("sessionTest3 ��session id ="+sessionID+"<br/>");
    		
    	}
    	catch(Exception ex){
    		ex.printStackTrace();
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	this.doGet(request, response);
	}

}
