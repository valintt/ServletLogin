//服务器读取客户端的cookie


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
 * Servlet implementation class CookieTest2
 */
@WebServlet("/CookieTest2")
public class CookieTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest2() {
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
			
			//从客户端读取所有cookie信息
			Cookie [] allCookies=request.getCookies();
			
			int i=0;
			//如果allCookies不为空
			if(allCookies!=null){
				//从中去除cookie
				for(i=0;i<allCookies.length;i++){
					//依次取出
					Cookie temp=allCookies[i];
					
					if(temp.getName().equals("color1")){
						//得到cookie的值
						String val=temp.getValue();
						
						pw.println("color1="+val);
						break;
					}
				}
				
				if(allCookies.length==i){
					pw.println("cookie 过期");
				}
			}
			else{
				pw.println("不存在color1这个cookie，或过期了");
			}
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
