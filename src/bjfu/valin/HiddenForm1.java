package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenForm1
 */
@WebServlet("/hiddenForm1")
public class HiddenForm1 extends HttpServlet {  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenForm1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try{
			//中文乱码，方法一
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			String test="男";
			pw.println("<html>");
			pw.println("<body>");
			pw.println("<h1>登录界面</h1>");
			//action提交给数据处理的url
			pw.println("<form action=hiddenForm2 method=post>");
			pw.println("用户名<input type=text name=username><br/>");
			pw.println("密码<input type=password name=password><br/>");
			//隐藏表单type=hidden；？？？？test乱码
			pw.println("<input type=hidden name=sex value="+test+"><br/>");
			pw.println("<input type=submit value=登录><br/>");
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
