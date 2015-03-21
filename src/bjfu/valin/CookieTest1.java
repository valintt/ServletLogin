//��������ͻ��˴���cookie

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
			
			//���û����ʸ�Servletʱ���ͽ���Ϣ���������û���cookie��
			//1.�������˴���һ��cookie
			Cookie myCookie=new Cookie("color1", "red");
			//2.��cookie���ڵ�ʱ�䣬sΪ��λ������ʱ��Ϊ�ۼ�ʱ��
			myCookie.setMaxAge(30);
			//���������ô���ʱ�䣬��ô��cookie���ᱻ����
			//3.����cookieд�ص��ͻ���
			response.addCookie(myCookie);
			
			pw.println("�Ѿ�������cookie");
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
