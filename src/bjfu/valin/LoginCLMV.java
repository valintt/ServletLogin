package bjfu.valin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginCL
 */
@WebServlet("/loginCLMV")
public class LoginCLMV extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCLMV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
  //����get����
    //request��ÿͻ��ˣ������������Ϣ
    //response��ͻ��ˣ���������ķ�����Ϣ
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//�ⲿ����conn��stmt��rs������finally�йر����ݿ�
		//Connection conn=null;
		//Statement stmt=null;
		//ResultSet rs=null;
		
		try{
			//�����û���������
			String u=request.getParameter("username");
			String p=request.getParameter("password");
			
			/********
			* //�������ݿ⣬������Ҫ��finally�йر���Դ�������˷����ݿ���Դ
			*8Class.forName("com.mysql.jdbc.Driver")
			* //�õ�����
			* conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			* //����һ��statement
			* stmt=conn.createStatement();
			* //ִ�в�ѯ������ResultSet����//top 1��ʾ��ѯһ���ͷ��أ�����ͽ��ڲ�ѯ���е�֮�󷵻ؽ��
			* //rs=stmt.executeQuery("select * from users where usersname='"+u+"' and password='"+p+"';");
			* rs=stmt.executeQuery("select password from users where usersname='"+u+"';");
			*************/
			
			//����UserBeanCL������һ������
			UserBeanCL ubc=new UserBeanCL();
			
			
			//ʹ��UserBeanCL��һ������
			if(ubc.checkUser(u, p)){
				//�û�����
				
				/*************
				 * String dbpasswd=rs.getString(1);
				 * if(dbpasswd.equals(p)){
				 * //�Ϸ�
				 */
				
					
					//�û�ѡ��checkbox
					String keep=request.getParameter("keep");
					
					if(keep!=null){
						//���û��������뱣���ڿͻ��ˣ�cookie��
						//����cookie
						Cookie name=new Cookie("myname", u);
						Cookie passwd=new Cookie("mypassword", p);
						
						//����ʱ��
						name.setMaxAge(14*24*3600);
						passwd.setMaxAge(14*24*3600);
					
					
						//��д���ͻ���
						response.addCookie(name);
						response.addCookie(passwd);
					}
					
					//����¼��֤�ɹ�����Ϣд��session
					//1�õ�session
					HttpSession hs=request.getSession(true);
					//�޸�session�Ĵ���ʱ�䣬��δ��λ
					hs.setMaxInactiveInterval(20);
					//��sessionд������
					hs.setAttribute("pass", "OK");
					
					
					//��ת��welcome��ʹ��sendRedirct����ͨ��uname������welcomeҳ�洫���û���
					
					response.sendRedirect("welcome?uname="+u+"&upass="+p);
				
				}
				else{
					//���Ϸ�
					//��ת
					response.sendRedirect("login");//дҪ��Servlet��url��
				}
			}
		
		/*********
		 * else {
		 * //�û���������
		 * //���Ϸ�
		 * //��ת
		 * response.sendRedirect("login");//дҪ��Servlet��url��
		 	* }
		 */
			
			//��֤
			
			/*
			if(rs.next()/*u.equals("valin")&&p.equals("123456")){
				//�Ϸ�
				//����¼��֤�ɹ�����Ϣд��session
				//1�õ�session
				HttpSession hs=request.getSession(true);
				//�޸�session�Ĵ���ʱ�䣬��δ��λ
				hs.setMaxInactiveInterval(20);
				//��sessionд������
				hs.setAttribute("pass", "OK");
				
				
				//��ת��welcome��ʹ��sendRedirct����ͨ��uname������welcomeҳ�洫���û���
				
				response.sendRedirect("welcome?uname="+u+"&upass="+p);
			}
			else{
				//���Ϸ�
				//��ת
				response.sendRedirect("login");//дҪ��Servlet��url��
			}
			*/
		//}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		/*******
		finally{
			//�ر����ݿ����Դ
			try {
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			} catch (SQLException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		
	}
		
		*******/
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}