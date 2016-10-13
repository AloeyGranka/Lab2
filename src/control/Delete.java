package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Delete extends ActionSupport{
	private String Title;
	public String execute() throws Exception {
		 try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/book","root","aloey25800258");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      System.out.println("Success connect Mysql server!");
		      //Statement stmt = connect.createStatement();
		      String sql = "delete from books where Title='"+Title+"'";  

		      try  
		      {  
		          Statement stmt = connect.createStatement();  
		         stmt.executeUpdate(sql);  
		      } 
		      catch (SQLException e)  
		      {  
		          e.printStackTrace();  
		      }  

		    }
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		
		return SUCCESS;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
}

