package bjfu.valin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HiddenForm2
 */
@WebServlet("/hiddenForm2")
public class HiddenForm2 extends HttpServlet {
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HiddenForm2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	try{
    		response.setContentType("text/html;charset=gbk");
    		PrintWriter pw=response.getWriter();
    		
    		String u=request.getParameter("username");
    		String p=request.getParameter("password");
    		//得到隐藏表单的内容；得到的sex乱码
    		String s=request.getParameter("sex");
    		
    		pw.println("username="+u);
    		pw.println("password="+p);
    		pw.println("sex="+s);
    		
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
