//处理删除某个用户

package bjfu.valin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteUserCL
 */
@WebServlet("/deleteUserCL")
public class DeleteUserCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserCL() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			//接收从welcome中传递的id号
			String id=request.getParameter("idusers");
			
			
			
			//调用UserBeanCL的删除用户的方法
			UserBeanCL ubc=new UserBeanCL();
			
			if(ubc.delete(id)){
				//删除成功
				response.sendRedirect("ok");
			}
			else{
				//删除失败
				response.sendRedirect("error");
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
