package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/main")
public class Main extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //����get����
    //request��ÿͻ��ˣ������������Ϣ
  //response��ͻ��ˣ���������ķ�����Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//�������룬����һ
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor=#00C12B>");
			
			pw.println("<img src=imgs/welcome.gif><hr/><center>");
			
			pw.println("<h1>������</h1>");
			pw.println("<a href=welcome>�����û�</a><br/>");
			pw.println("<a href=???>����û�</a><br/>");
			pw.println("<a href=???>�����û�</a><br/>");
			pw.println("<a href=???>��ȫ�˳�</a><br/>");
			
			pw.println("</center><hr/><img src=imgs/pikaqiugif1.gif>");
			
			pw.println("</body>");
			pw.println("</html>");
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
