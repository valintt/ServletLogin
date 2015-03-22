//处理修改用户用户

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
@WebServlet("/updateCL")
public class UpdateCL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCL() {
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
			String newId=request.getParameter("newId");
			//String name=request.getParameter("usersname");
			
			String newPassword=request.getParameter("newPassword");
			String newMail=request.getParameter("newMail");
			String newGrade=request.getParameter("newGrade");
			
			
			
			//调用UserBeanCL的修改用户的方法
			UserBeanCL ubc=new UserBeanCL();
			
			if(ubc.update(newId,newPassword,newMail,newGrade)){
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
