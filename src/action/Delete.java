package action;
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
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
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

