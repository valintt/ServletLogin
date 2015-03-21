package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest3
 */
@WebServlet("/sessionTest3")
public class SessionTest3 extends HttpServlet { 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try{
    		//中文乱码
    		response.setContentType("text/html;charset=gbk");
    		
    		PrintWriter pw=response.getWriter();
    		//得到和request相关联的session，如果没有就创建session
    		HttpSession ht=request.getSession(true);
    		//得到session的id，这是由容器分配的
    		String sessionID=ht.getId();
    		
    		ht.setAttribute("test1", "李林");
    		ht.setAttribute("test2", "王菲");
    		
    		pw.println("在没有删除test1属性前test1="+ht.getAttribute("test1")+"<br/>");
    		//删除session中的test1的属性
    		ht.removeAttribute("test1");
    		//删除全部session的属性
    		//ht.setMaxInactiveInterval(0);？？？？？此方法不成功
    		pw.println("在删除test1属性后test1="+ht.getAttribute("test1")+"<br/>");
    		pw.println("在删除test1属性后test2="+ht.getAttribute("test2")+"<br/>");
    		
    		
    		pw.println("sessionTest3 的session id ="+sessionID+"<br/>");
    		
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
