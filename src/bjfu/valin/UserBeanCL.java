//����һ�������ࣨ����users��������UserBean�ļ�
//ҵ���߼�

package bjfu.valin;

import java.sql.*;
import java.util.ArrayList;

public class UserBeanCL{
	
	//ҵ���߼�
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	private int pageCount=0;//���м�ҳ������
	
	//��ҳ��ʾ������õ����ݿ��еļ�¼������װ��ArrayList�У����ظ�LoginCL
	public ArrayList<UserBean> getResultByPage(int pageNow, int pageSize){
		
		ArrayList<UserBean> al=new ArrayList<UserBean>();
		
		int rowCount=0;//���м�����¼�����
		
		
		try {
			
			//�õ����ݿ�����
			ConnDB cd=new ConnDB();
			conn=cd.getConn();
			
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
			//limit x,y ��ʾȥ����x-1��ʼ��y����¼
			ps=conn.prepareStatement("select * from users where idusers limit ?,?");
			//error:ps=conn.prepareStatement("select * from users where idusers limit "+pageNow-1+","+pageSize);
			
			
			//������ֵ,?���Զ�ת��
			ps.setInt(1, pageSize*(pageNow-1));
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			
			while(rs.next()){
				
				//��rs�е�ÿһ����¼����װ��UserBean ub��
				UserBean ub=new UserBean();
				ub.setUserID(rs.getInt(1));
				ub.setUserName(rs.getString(2));
				ub.setPassword(rs.getString(3));
				ub.setMail(rs.getString(4));
				ub.setGrade(rs.getInt(5));
				
				//��ub���뵽ArrayList al��
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
	
	//����pageCount
	public int getPageCount(){
		return this.pageCount;
	}
	
	//��֤�û�
	public boolean checkUser(String u, String p){
		boolean bool=false;
		
		try{
			
			//�õ�����
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
	
	
	//close���ݿ�����
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