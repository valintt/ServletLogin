//��ServletContext�еõ�����


package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletContextTest2
 */
@WebServlet("/ServletContextTest2")
public class ServletContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContextTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try{
			response.setContentType("text/html;charset=gbk");
			
			PrintWriter pw=response.getWriter();
			
			//�õ�ServletContext
			ServletContext sc=this.getServletContext();
			//�õ�sc������myInfo��Ӧ��ֵ
			String info=(String)sc.getAttribute("myInfo");
			
			pw.println("��ServletContext�еõ�����myInfo����Ӧ��ֵΪ"+info);
			
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
