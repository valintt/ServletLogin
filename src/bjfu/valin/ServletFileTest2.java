//�����Servlet�в����ļ�
//��ʾ������ļ�д������

package bjfu.valin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletFileTest2
 */
@WebServlet("/ServletFileTest2")
public class ServletFileTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFileTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedWriter bw=null;
		
		try{
			
			//��������
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			
			//����һ��FileWiter�����ڴ�����->�����ļ���д�룬�������
			FileWriter f=new FileWriter("d:\\test.txt");
			
			bw=new BufferedWriter(f);
			//д��һ������
			String str="123456";
			bw.write(str);
			
			
			pw.println("д���ļ������ݣ�"+str);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			//һ���ر��ļ���
			 bw.close();
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
