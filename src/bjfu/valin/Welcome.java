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
    //处理get请求
    //request获得客户端（浏览器）的信息
    //response向客户端（浏览器）的返回信息
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//得到session
		//解决中文乱码
		//response.setCharacterEncoding("gbk");不识别
		response.setContentType("text/html;charset=gbk");
		PrintWriter pw=response.getWriter();
		String name="";
		String passwd="";
		HttpSession hs=request.getSession(true);
		
		String nyName=(String)hs.getAttribute("username");
		
		String val=(String)hs.getAttribute("pass");
		
		
		try{	
			if(val==null){
				//如果session中没有用户信息，再看看有没有从哦哦开车信息
				
				//从客户端得到所有的cookie信息
				Cookie [] allCookies=request.getCookies();
				
				int i=0;
				//如果allCookies不为空
				if(allCookies!=null){
					//从中去除cookie
					for(i=0;i<allCookies.length;i++){
						//依次取出
						Cookie temp=allCookies[i];
						
						if(temp.getName().equals("myname")){
							//得到cookie的用户名
							name=temp.getValue();
							
						}
						else if(temp.getName().equals("mypassword")){
							//得到cookie的密码
							passwd=temp.getValue();
							
						}
					}
					
					//
					if((!name.equals(""))&&(!passwd.equals(""))){
						//到loginCL去验证
						response.sendRedirect("loginCL?username="+name+"&password="+passwd);
						return;
					}
					
				}
				
					response.sendRedirect("login?info=error1");
					return;
				
			}
			
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		//得到从loginCL传递的用户名
		//得到loginCL传递的密码
		String u=request.getParameter("uname");
		String p=request.getParameter("upass");
		
		
		
		//************分页功能
		/***
		 * int pageSize=5;//一夜显示几条记录
		 * int pageNow=1;//希望显示第几页
		 * int rowCount=0;//共有几条记录，查表
		 * int pageCount=0;//共有几页（计算）
		 * //动态的接收pageNow
		 * String sPageNow=request.getParameter("pageNowLink");
		
		* //sPageNow==null表示pageNow的空间不存在
		* if(sPageNow!=null){
		* 	pageNow=Integer.parseInt(sPageNow);
		* }
		
		* //Statement：用于发送基本 SQL 语句
		* //PreparedStatement：用于发送准备好的语句或基本 SQL 语句（派生自 Statement）
		* Connection conn=null;
		* PreparedStatement ps=null;
		* ResultSet rs=null;
		*/
		
		int pageSize=5;//一夜显示几条记录
		int pageNow=1;//希望显示第几页
		
		//动态的接受pageNow
		String sPageNow=request.getParameter("pageNowLink");
		
		if(sPageNow!=null){
			pageNow=Integer.parseInt(sPageNow);
		}
		
		//调用userBean处理
		UserBeanCL ubc=new UserBeanCL();
		ArrayList al=ubc.getResultByPage(pageNow, pageSize);
		
		//首先得到rowCount
		//链接数据库，后面需要在finally中关闭资源，否则浪费数据库资源
	//	try {
			/************
			Class.forName("com.mysql.jdbc.Driver");
			//得到链接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			//PreparedStatement：用于发送准备好的语句或基本 SQL 语句（派生自 Statement）
			ps=conn.prepareStatement("select count(*) from users");
			//executeQuery表示执行准备好的SQL语句，并返回执行结果
			rs=ps.executeQuery();
			//显示
			
			
			if(rs.next()){
				rowCount=rs.getInt(1);
			}
			
			//计算pageCount
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
			
			//关闭上面的rs，ps连接
		//	if(rs!=null){
		//		rs.close();
		//	}
		//	if(ps!=null){
		//		ps.close();
		//	}
			
			
			
			//limit x,y 表示去除从x-1开始的y条记录
			ps=conn.prepareStatement("select * from users where idusers limit ?,?");
			//error:ps=conn.prepareStatement("select * from users where idusers limit "+pageNow-1+","+pageSize);
			
			
			//给？赋值,?会自动转换
			ps.setInt(1, pageSize*(pageNow-1));
			ps.setInt(2, pageSize);
			
			rs=ps.executeQuery();
			****************/
			
			
			
			
			//PrintWriter pw=response.getWriter();														
			pw.println("<html>");
			pw.println("<body bgcolor=#00C12B>");
			
			pw.println("<img src=imgs/welcome.gif>");
			
			pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎您："+nyName+"<img src=imgs/s.png><hr/><center>");
			
			
			pw.println("<h1>管理用户</h1>");
			
			//pw.println(u+",Welcome! your password is "+p);
			//超链接
			pw.println("<br/><a href=login>退出</a><br/>");
		
			
			
			//表头
			pw.println("<table border=1>");
			pw.println("<tr bgcolor=#007D1C><th>id</th><th>name</th><th>password</th><th>mail</th><th>grade</th><th>修改用户</th><th>删除用户</th></tr>");
			
			
			//定义一个颜色数组
			String [] myColor={"#FFE240","#7147D7"};
			
			for(int i=0;i<al.size();i++){
				//显示表格
				
				UserBean ub=(UserBean)al.get(i);
				pw.println("<tr bgcolor="+myColor[i%2]+">");
				pw.println("<td>"+ub.getUserID()+"</td>");
				pw.println("<td>"+ub.getUserName()+"</td>");
				pw.println("<td>"+ub.getPassword()+"</td>");
				pw.println("<td>"+ub.getMail()+"</td>");
				pw.println("<td>"+ub.getGrade()+"</td>");
				
				
				pw.println("<td><a href=update?idusers="+ub.getUserID()+"&usersname="+ub.getUserName()+"&password="+ub.getPassword()+"&mail="+ub.getMail()+"&grade="+ub.getGrade()+">修改用户</a></td>");
				
				//onclick=\"return window.confirm('您确认要删除用户吗？')\" 确认窗口
				pw.println("<td><a href=deleteUserCL?idusers="+ub.getUserID()+" onclick=\"return window.confirm('您确认要删除用户吗？')\">删除用户</a></td>");
				pw.println("</tr>");
			}
			
			pw.println("</table>");
			
			//上一页
			if(pageNow!=1){
				pw.println("<a href=welcome?pageNowLink="+(pageNow-1)+">上一页</a>");
			}
			
			//显示超链接，分页，数据记录太多时：每一页显示从pageNow开始，到pageNow+pageSize-1页
			for(int i=pageNow;i<=pageNow+4;i++){
				//将i的值提交，连接到pageNow
				pw.println("<a href=welcome?pageNowLink="+i+">"+i+"</a>");
			}
			
			int pageCount=ubc.getPageCount();
			//下一页
			if(pageNow!=pageCount){
				pw.println("<a href=welcome?pageNowLink="+(pageNow+1)+">下一页</a>");
			}
			
			//制定跳转到某一页
			//这里实际是一个表单
			pw.println("<form action=welcome>");
			pw.println("跳转到<input type=text name=pageNowLink>页");
			pw.println("<input type=submit value=go>");
			pw.println("</form>");
			
			
			//该网页被访问的次数
			pw.println("<br/>访问次数："+this.getServletContext().getAttribute("visitTimes").toString());
			
			//pw.println("<br/>你的ip="+request.getRemoteAddr()+"<br/>");
			//pw.println("你的主机名="+request.getRemoteHost()+"<br/>");
			pw.println("</center><hr/><img src=imgs/pikaqiugif1.gif>");
			
			pw.println("</body>");
			pw.println("</html>");
			
	//	} catch (Exception ex) {
			// TODO Auto-generated catch block
	
	//		ex.printStackTrace();
			
	//	} catch (SQLException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}
	//	finally{
			//关闭数据库的资源
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
