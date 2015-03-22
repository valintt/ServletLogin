//操作失败页面

package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserCL
 */
@WebServlet("/error")
public class Error extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Error() {
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
			
			pw.println("<html>");
			pw.println("<body bgcolor=#00C12B>");
			
			pw.println("<img src=imgs/welcome.gif><hr/><center>");
			
			pw.println("<h1>操作失败</h1>");
			pw.println("<a href=main>返回主页面</a>");
			pw.println("<a href=welcome>继续操作</a>");
			
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}
