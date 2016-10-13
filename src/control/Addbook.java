package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


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
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		    // System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      //System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/book","root","aloey25800258");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      //System.out.println("Success connect Mysql server!");
		   
		      String sql="insert into books(ISBN,Title,AuthorID,Publisher,Publisherdate,Price) values(?,?,?,?,?,?)";                                                          //user 为你表的名称
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
		     if (i==1)
		      {
		    	 return SUCCESS;
		      }
		     else
		     {
		    	 return ERROR;
		     }
		    
		  }

	
		
}
