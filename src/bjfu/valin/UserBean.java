//����һ��UserBean <------> users��ӳ��
//UserBean��һ������<------>users���һ����¼��Ӧ
//����

package bjfu.valin;

public class UserBean{
	
	private int userID;
	private String userName;
	private String password;
	private String mail;
	private int grade;
	
	public void setUserID(int userID){
		this.userID=userID;
	}
	
	public int getUserID(){
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}