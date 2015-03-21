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
@WebServlet("/loginCL")
public class LoginCL extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCL() {
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
		
		//外部申明conn，stmt，rs；用于finally中关闭数据库
		//Connection conn=null;
		//Statement stmt=null;
		//ResultSet rs=null;
		
		try{
			//接收用户名和密码
			String u=request.getParameter("username");
			String p=request.getParameter("password");
			
			/********
			* //链接数据库，后面需要在finally中关闭资源，否则浪费数据库资源
			*8Class.forName("com.mysql.jdbc.Driver")
			* //得到链接
			* conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			* //创建一个statement
			* stmt=conn.createStatement();
			* //执行查询，返回ResultSet对象//top 1表示查询一个就返回，否则就将在查询所有的之后返回结果
			* //rs=stmt.executeQuery("select * from users where usersname='"+u+"' and password='"+p+"';");
			* rs=stmt.executeQuery("select password from users where usersname='"+u+"';");
			*************/
			
			//调用UserBeanCL，创建一个对象
			UserBeanCL ubc=new UserBeanCL();
			
			
			//使用UserBeanCL的一个方法
			if(ubc.checkUser(u, p)){
				//用户存在
				
				/*************
				 * String dbpasswd=rs.getString(1);
				 * if(dbpasswd.equals(p)){
				 * //合法
				 */
				
					
					//用户选中checkbox
					String keep=request.getParameter("keep");
					
					if(keep!=null){
						//将用户名和密码保存在客户端（cookie）
						//创建cookie
						Cookie name=new Cookie("myname", u);
						Cookie passwd=new Cookie("mypassword", p);
						
						//设置时间
						name.setMaxAge(14*24*3600);
						passwd.setMaxAge(14*24*3600);
					
					
						//回写到客户端
						response.addCookie(name);
						response.addCookie(passwd);
					}
					
					//将登录验证成功的信息写入session
					//1得到session
					HttpSession hs=request.getSession(true);
					//修改session的存在时间，秒未单位
					hs.setMaxInactiveInterval(20);
					//向session写入属性
					hs.setAttribute("pass", "OK");
					
					
					//跳转到welcome，使用sendRedirct方法通过uname变量向welcome页面传送用户名
					
					response.sendRedirect("welcome?uname="+u+"&upass="+p);
				
				}
				else{
					//不合法
					//跳转
					response.sendRedirect("login");//写要到Servlet的url名
				}
			}
		
		/*********
		 * else {
		 * //用户名不存在
		 * //不合法
		 * //跳转
		 * response.sendRedirect("login");//写要到Servlet的url名
		 	* }
		 */
			
			//验证
			
			/*
			if(rs.next()/*u.equals("valin")&&p.equals("123456")){
				//合法
				//将登录验证成功的信息写入session
				//1得到session
				HttpSession hs=request.getSession(true);
				//修改session的存在时间，秒未单位
				hs.setMaxInactiveInterval(20);
				//向session写入属性
				hs.setAttribute("pass", "OK");
				
				
				//跳转到welcome，使用sendRedirct方法通过uname变量向welcome页面传送用户名
				
				response.sendRedirect("welcome?uname="+u+"&upass="+p);
			}
			else{
				//不合法
				//跳转
				response.sendRedirect("login");//写要到Servlet的url名
			}
			*/
		//}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		/*******
		finally{
			//关闭数据库的资源
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
