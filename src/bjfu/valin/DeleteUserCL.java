//����ɾ��ĳ���û�

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
			//���մ�welcome�д��ݵ�id��
			String id=request.getParameter("idusers");
			
			
			
			//����UserBeanCL��ɾ���û��ķ���
			UserBeanCL ubc=new UserBeanCL();
			
			if(ubc.delete(id)){
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