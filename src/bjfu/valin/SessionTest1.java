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
 * Servlet implementation class SessionTest1
 */
@WebServlet("/sessionTest1")
public class SessionTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
    		//中文乱码
    		response.setContentType("text/html;charset=gbk");
    		
    		PrintWriter pw=response.getWriter();
    		//得到和request相关联的session，如果没有就创建session
    		HttpSession ht=request.getSession(true);
    		//得到session的id，这是由容器分配的
    		String sessionID=ht.getId();
    		
    		pw.println("sessionTest1 的session id ="+sessionID+"<br/>");
    		
    		//向session中添加一个属性（String类型）
    		ht.setAttribute("name", "valin");
    		//如果不指定时间，session的有效期为30min
    		//制定session的时间为30s
    		ht.setMaxInactiveInterval(30);
    		
    		pw.println("在session中放入了一个属性 name=valin");
    		
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
