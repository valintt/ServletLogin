//�����޸��û��û�

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
			//���մ�welcome�д��ݵ�id��
			String newId=request.getParameter("newId");
			//String name=request.getParameter("usersname");
			
			String newPassword=request.getParameter("newPassword");
			String newMail=request.getParameter("newMail");
			String newGrade=request.getParameter("newGrade");
			
			
			
			//����UserBeanCL���޸��û��ķ���
			UserBeanCL ubc=new UserBeanCL();
			
			if(ubc.update(newId,newPassword,newMail,newGrade)){
				//ɾ���ɹ�
				response.sendRedirect("ok");
			}
			else{
				//ɾ��ʧ��
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
