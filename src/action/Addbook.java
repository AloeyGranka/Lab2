package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Addbook extends ActionSupport{
	private String ISBN,Title,AuthorID,Publisher,PublishDate,Price;
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String execute() throws Exception {
		   int i=0;  
		try {
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		    // System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      //System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
		           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
		      //System.out.println("Success connect Mysql server!");
		   
		      String sql="insert into books(ISBN,Title,AuthorID,Publisher,Publisherdate,Price) values(?,?,?,?,?,?)";                                                          //user Ϊ��������
		      PreparedStatement preStmt = connect.prepareStatement(sql);
		      preStmt.setString(1,ISBN);
		      preStmt.setString(2,Title);
		      preStmt.setString(3,AuthorID);
		      preStmt.setString(4,Publisher);
		      preStmt.setString(5,PublishDate);
		      preStmt.setString(6,Price);
		      i=preStmt.executeUpdate(); 
		 
		      
		    }
		    
		    catch (Exception e) {
		      //System.out.print("get data error!");
		      e.printStackTrace();
		    }
		    
		    Connection connect = DriverManager.getConnection(
			          "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
			           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
			      int count = 0; 
			      Statement stmt = connect.createStatement();
			      ResultSet rs2 = stmt.executeQuery("select * from authors where AuthorID='"+AuthorID+"'");
			                                                              //user Ϊ��������
			      while (rs2.next()) {

             
			          count = rs2.getInt(1); 

			        }
			      
			      
			ActionContext context = ActionContext.getContext();
			context.getSession().put("AuthorID", AuthorID);
			  	if (count == 0 )
			  	{
			  		return ERROR;
			  	}
		     else
		     {
		    	 return SUCCESS;
		     }
		    
		  }

	
		
}
