//如何在Servlet中操作文件
//演示如何读取文件内容

package bjfu.valin;

import java.io.BufferedReader;
import java.io.FileReader;
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
@WebServlet("/ServletFileTest1")
public class ServletFileTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFileTest1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=null;
		
		try{
			
			//中文乱码
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			
			//创建一个FileReader
			FileReader f=new FileReader("d:\\test.txt");
			
			br=new BufferedReader(f);
			//读出一行数据
			String numVal=br.readLine();
			
			
			pw.println("文件中读取的数据："+numVal);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			//一定关闭文件流
			 br.close();
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
