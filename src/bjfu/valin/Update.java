//�޸��û���Ϣ�Ľ���

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
@WebServlet("/update")
public class Update extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
			
			String id=request.getParameter("idusers");
			String name=request.getParameter("usersname");
			String password=request.getParameter("password");
			String mail=request.getParameter("mail");
			String grade=request.getParameter("grade");
			
			
			//�������룬����һ
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor=#00C12B>");
			
			pw.println("<img src=imgs/welcome.gif><hr/><center>");
			
			pw.println("<h1>�޸��û�����</h1>");
			//action�ύ�����ݴ����url
			pw.println("<form action=updateCL method=post>");
			//��ͷ
			pw.println("<table border=1>");
			
			pw.println("<tr bgcolor=#65E080><td>id</td><td><input name=newId readonly type=text value="+id+"></td></tr>");
			pw.println("<tr bgcolor=#65E080><td>name</td><td><input readonly type=text value="+name+"></td></tr>");
			pw.println("<tr bgcolor=#65E080><td>password</td><td><input name=newPassword type=text value="+password+"></td></tr>");
			pw.println("<tr bgcolor=#65E080><td>email</td><td><input name=newMail type=text value="+mail+"></td></tr>");
			pw.println("<tr bgcolor=#65E080><td>grade</td><td><input name=newGrade type=text value="+grade+"></td></tr>");
			
			
			pw.println("</table>");																													
			
			pw.println("<input type=submit value=ȷ&nbsp;��><br/>");
			pw.println("</form>");
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
