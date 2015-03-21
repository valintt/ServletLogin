//如何在Servlet中操作文件
//演示如何向文件写入内容

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
			
			//中文乱码
			response.setContentType("text/html;charset=gbk");
			PrintWriter pw=response.getWriter();
			
			//创建一个FileWiter，看内存数据->磁盘文件（写入，输出流）
			FileWriter f=new FileWriter("d:\\test.txt");
			
			bw=new BufferedWriter(f);
			//写入一行数据
			String str="123456";
			bw.write(str);
			
			
			pw.println("写入文件的数据："+str);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			//一定关闭文件流
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
