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
  //处理get请求
    //request获得客户端（浏览器）的信息
  //response向客户端（浏览器）的返回信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//中文乱码，方法一
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<body bgcolor=#00C12B>");
			
			pw.println("<img src=imgs/welcome.gif><hr/><center>");
			
			pw.println("<h1>主界面</h1>");
			pw.println("<a href=welcome>管理用户</a><br/>");
			pw.println("<a href=???>添加用户</a><br/>");
			pw.println("<a href=???>查找用户</a><br/>");
			pw.println("<a href=???>安全退出</a><br/>");
			
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
