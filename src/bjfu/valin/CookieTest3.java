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
 * Servlet implementation class CookieTest3
 */
@WebServlet("/CookieTest3")
public class CookieTest3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest3() {
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
			
			//�ӿͻ��˵õ�����cookie
			Cookie [] allCookies=request.getCookies();
			
			int i=0;
			//���allCookies��Ϊ��
			if(allCookies!=null){
				//����ȥ��cookie
				for(i=0;i<allCookies.length;i++){
					//����ȡ��
					Cookie temp=allCookies[i];
					
					if(temp.getName().equals("color")){
						//ɾ��cookie
						temp.setMaxAge(0);
						pw.println("ɾ����color���cookie");
						break;
					}
				}
				
				if(allCookies.length==i){
					pw.println("cookie ����");
				}
			}
			else{
				pw.println("������color1���cookie���������");
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
