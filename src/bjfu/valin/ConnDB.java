//�����ݿ��еõ�����


package bjfu.valin;

import java.sql.*;

public class ConnDB{
	private Connection conn=null;
	
	public Connection getConn(){
		try{
			//�������ݿ�����
			Class.forName("com.mysql.jdbc.Driver");
			//�õ�����
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/valindb","valin","131191");
			
		}
		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return conn;
	}
}