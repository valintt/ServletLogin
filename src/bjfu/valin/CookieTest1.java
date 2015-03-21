//服务器向客户端创建cookie

package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest1
 */
@WebServlet("/CookieTest1")
public class CookieTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			response.setContentType("text/html;lcharset=gbk");
			PrintWriter pw=response.getWriter();
			
			//当用户访问该Servlet时，就将信息创建到该用户的cookie中
			//1.服务器端创建一个cookie
			Cookie myCookie=new Cookie("color1", "red");
			//2.该cookie存在的时间，s为单位，存在时间为累计时间
			myCookie.setMaxAge(30);
			//若果不设置存在时间，那么该cookie不会被保存
			//3.将该cookie写回到客户端
			response.addCookie(myCookie);
			
			pw.println("已经创建了cookie");
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
