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
@WebServlet("/login")
public class Login extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
			pw.println("<body>");
			pw.println("<h1>��¼����</h1>");
			//action�ύ�����ݴ����url
			pw.println("<form action=loginCL method=post>");
			pw.println("�û���<input type=text name=username><br/>");
			pw.println("����<input type=password name=password><br/>");
			//����cookie����Ϣѡ��
			pw.println("<input type=checkbox name=keep value=2>�����ڲ������µ�¼<br/>");
			
			pw.println("<input type=submit value=��¼><br/>");
			pw.println("</form>");
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
