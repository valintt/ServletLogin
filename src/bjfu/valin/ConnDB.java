//从数据库中得到链接


package bjfu.valin;

import java.sql.*;

public class ConnDB{
	private Connection conn=null;
	
	public Connection getConn(){
		try{
			//加载数据库链接
			Class.forName("com.mysql.jdbc.Driver");
			//得到链接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return conn;
	}
}