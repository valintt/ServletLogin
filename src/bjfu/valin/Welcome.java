package bjfu.valin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Servlet implementation class Welcome
 */
@WebServlet("/welcome")
public class Welcome extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
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
		//�õ�session
		//�����������
		//response.setCharacterEncoding("gbk");��ʶ��
		response.setContentType("text/html;charset=gbk");
		PrintWriter pw=response.getWriter();
		String name="";
		String passwd="";
		HttpSession hs=request.getSession(true);
		String val=(String)hs.getAttribute("pass");
		
		FileReader fr=null;
		BufferedReader br=null;
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		try{	
			if(val==null){
				//���session��û���û���Ϣ���ٿ�����û�д�ŶŶ������Ϣ
				
				//�ӿͻ��˵õ����е�cookie��Ϣ
				Cookie [] allCookies=request.getCookies();
				
				int i=0;
				//���allCookies��Ϊ��
				if(allCookies!=null){
					//����ȥ��cookie
					for(i=0;i<allCookies.length;i++){
						//����ȡ��
						Cookie temp=allCookies[i];
						
						if(temp.getName().equals("myname")){
							//�õ�cookie���û���
							name=temp.getValue();
							
						}
						else if(temp.getName().equals("mypassword")){
							//�õ�cookie������
							passwd=temp.getValue();
							
						}
					}
					
					//
					if((!name.equals(""))&&(!passwd.equals(""))){
						//��loginCLȥ��֤
						response.sendRedirect("loginCL?username="+name+"&password="+passwd);
						return;
					}
					
				}
				
					response.sendRedirect("login?info=error1");
					return;
				
			}
			
			
			//������ҳ���ʴ���
			fr=new FileReader("d:\\myCounter.txt");
			br=new BufferedReader(fr);
			
			//����һ������
			String numVal=br.readLine();
			
			//��StringתΪint
			int times=Integer.parseInt(numVal);
			
			//����һ��
			times++;
			
			fw=new FileWriter("d:\\myCounter.txt");
			bw=new BufferedWriter(fw);
			
			bw.write(times);
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			br.close();
			bw.close();
		}
		
		//�õ���loginCL���ݵ��û���
		//�õ�loginCL���ݵ�����
		String u=request.getParameter("uname");
		String p=request.getParameter("upass");
		
		
		
		//************��ҳ����
		/***
		 * int pageSize=5;//һҹ��ʾ������¼
		 * int pageNow=1;//ϣ����ʾ�ڼ�ҳ
		 * int rowCount=0;//���м�����¼�����
		 * int pageCount=0;//���м�ҳ�����㣩
		 * //��̬�Ľ���pageNow
		 * String sPageNow=request.getParameter("pageNowLink");
		
		* //sPageNow==null��ʾpageNow�Ŀռ䲻����
		* if(sPageNow!=null){
		* 	pageNow=Integer.parseInt(sPageNow);
		* }
		
		* //Statement�����ڷ��ͻ��� SQL ���
		* //PreparedStatement�����ڷ���׼���õ�������� SQL ��䣨������ Statement��
		* Connection conn=null;
		* PreparedStatement ps=null;
		* ResultSet rs=null;
		*/
		
		int pageSize=5;//һҹ��ʾ������¼
		int pageNow=1;//ϣ����ʾ�ڼ�ҳ
		
		//��̬�Ľ���pageNow
		String sPageNow=request.getParameter("pageNowLink");
		
		if(sPageNow!=null){
			pageNow=Integer.parseInt(sPageNow);
		}
		
		//����userBean����
		UserBeanCL ubc=new UserBeanCL();
		ArrayList<UserBean> al=ubc.getResultByPage(pageNow, pageSize);
		
		//���ȵõ�rowCount
		//�������ݿ⣬������Ҫ��finally�йر���Դ�������˷����ݿ���Դ
	//	try {
			/************
			Class.forName("com.mysql.jdbc.Driver");
			//�õ�����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			//PreparedStatement�����ڷ���׼���õ�������� SQL ��䣨������ Statement��
			ps=conn.prepareStatement("select count(*) from users");
			//executeQuery��ʾִ��׼���õ�SQL��䣬������ִ�н��
			rs=ps.executeQuery();
			//��ʾ
			
			
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
			
			//����pageCount
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
			
			//�ر������rs��ps����
		//	if(rs!=null){
		//		rs.close();
		//	}
		//	if(ps!=null){
		//		ps.close();
		//	}
			
			
			
			//limit x,y ��ʾȥ����x-1��ʼ��y����¼
			ps=conn.prepareStatement("select * from users where idusers limit ?,?");
			//error:ps=conn.prepareStatement("select * from users where idusers limit "+pageNow-1+","+pageSize);
			
			
			//������ֵ,?���Զ�ת��
			ps.setInt(1, pageSize*(pageNow-1));
			ps.setInt(2, pageSize);
			
			rs=ps.executeQuery();
			****************/
			
			
			
			
			//PrintWriter pw=response.getWriter();
			pw.println("<html>");
			pw.println("<body><center>");
			//��Servlet����ʾͼƬ,���ƴ�С���ȸ߶�
			pw.println("<img src=imgs/welcome.gif><br/>");
			
			pw.println(u+",Welcome! your password is "+p);
			//������
			pw.println("<br/><a href=login>�˳�</a><br/>");
		
			
			
			//��ͷ
			pw.println("<table border=1>");
			pw.println("<tr><th>id</th><th>name</th><th>password</th><th>mail</th><th>grade</th></tr>");
			
			
			for(int i=0;i<al.size();i++){
				//��ʾ����
				
				UserBean ub=(UserBean)al.get(1);
				pw.println("<tr>");
				pw.println("<td>"+ub.getUserID()+"</td>");
				pw.println("<td>"+ub.getUserName()+"</td>");
				pw.println("<td>"+ub.getPassword()+"</td>");
				pw.println("<td>"+ub.getMail()+"</td>");
				pw.println("<td>"+ub.getGrade()+"</td>");
				pw.println("</tr>");
			}
			
			pw.println("</table>");
			
			//��һҳ
			if(pageNow!=1){
				pw.println("<a href=welcome?pageNowLink="+(pageNow-1)+">��һҳ</a>");
			}
			
			//��ʾ�����ӣ���ҳ�����ݼ�¼̫��ʱ��ÿһҳ��ʾ��pageNow��ʼ����pageNow+pageSize-1ҳ
			for(int i=pageNow;i<=pageNow+4;i++){
				//��i��ֵ�ύ�����ӵ�pageNow
				pw.println("<a href=welcome?pageNowLink="+i+">"+i+"</a>");
			}
			
			int pageCount=ubc.getPageCount();
			//��һҳ
			if(pageNow!=pageCount){
				pw.println("<a href=welcome?pageNowLink="+(pageNow+1)+">��һҳ</a>");
			}
			
			pw.println("</center></body>");
			pw.println("</html>");
			
	//	} catch (Exception ex) {
			// TODO Auto-generated catch block
	
	//		ex.printStackTrace();
			
	//	} catch (SQLException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	//	finally{
			//�ر����ݿ����Դ
	//		try {
	//			if(rs!=null){
	//				rs.close();
	//			}
	//			if(ps!=null){
	//				ps.close();
		//		}
		//		if(conn!=null){
		//			conn.close();
		//		}
		//	} catch (SQLException ex) {
		//		// TODO Auto-generated catch block
		//		ex.printStackTrace();
		//	}
		
	//	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

}