//这是一个处理类（处理users表），操作UserBean文件
//业务逻辑

package bjfu.valin;

import java.sql.*;
import java.util.ArrayList;

public class UserBeanCL{
	
	//业务逻辑
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;//共有几页（计算
	
	//分页显示结果，得到数据库中的记录，并封装到ArrayList中，返回给LoginCL
	public ArrayList<UserBean> getResultByPage(int pageNow, int pageSize){
		
		ArrayList<UserBean> al=new ArrayList<UserBean>();
		
		int rowCount=0;//共有几条记录，查表
		
		
		try {
			
			//得到数据库链接
			ConnDB cd=new ConnDB();
			conn=cd.getConn();
			
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
			//limit x,y 表示去除从x-1开始的y条记录
			ps=conn.prepareStatement("select * from users where idusers limit ?,?");
			//error:ps=conn.prepareStatement("select * from users where idusers limit "+pageNow-1+","+pageSize);
			
			
			//给？赋值,?会自动转换
			ps.setInt(1, pageSize*(pageNow-1));
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				//将rs中的每一条记录，封装到UserBean ub中
				UserBean ub=new UserBean();
				ub.setUserID(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setMail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				
				//将ub放入到ArrayList al中
				al.add(ub);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			this.close();
		}
		
		return al;
	}
	
	//返回pageCount
	public int getPageCount(){
		return this.pageCount;
	}
	
	//验证用户
	public boolean checkUser(String u, String p){
		boolean bool=false;
		
		try{
			
			//得到连接
			ConnDB cd=new ConnDB();
			conn=cd.getConn();
			
			ps=conn.prepareStatement("select password from users where usersname='"+u+"';");
			
			rs=ps.executeQuery();
			
			if(rs.next()){
				String dbPasswd=rs.getString(1);
				if(dbPasswd.equals(p)){
					bool=true;
				}
			}
					
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			this.close();
		}
		return bool;
	}
	
	
	//close数据库链接
	public void close(){
		try{
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(ps!=null){
				ps.close();
				ps=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}