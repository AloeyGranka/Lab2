package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class UpdateII extends ActionSupport{
	private String ISBN,Title,AuthorID,Publisher,PublisherDate,Price;
	
	public String execute() throws Exception {
		System.out.println(Title);
		System.out.println(ISBN);
		System.out.println(AuthorID);
		System.out.println(Publisher);
		System.out.println(PublisherDate);
		System.out.println(Price);
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
			 //String sql="update books set ISBN=?,AuthorID=?,Publisher=?,Publisherdate=?,Price=?  where Title='"+Title+"';";
//			 PreparedStatement preStmt =connect.prepareStatement(sql);  
//		       preStmt.setString(1,ISBN);  
//		        preStmt.setString(2,AuthorID);//���ߣ�preStmt.setInt(1,ֵ);  
//		        preStmt.setString(3,Publisher);  
//		        preStmt.setString(4,PublisherDate);  
//		        preStmt.setString(5,Price);//���ߣ�preStmt.setInt(1,ֵ);   
//			 
			      Statement statement = connect.createStatement();
			      statement.executeUpdate("update books set Publisher = '" + Publisher +"' where Title = '" + Title +"';" );
			      statement.executeUpdate("update books set ISBN = '" + ISBN +"' where Title = '" + Title +"';" );
			      statement.executeUpdate("update books set AuthorID = '" + AuthorID +"' where Title = '" + Title +"';" );
			      statement.executeUpdate("update books set Price = '" + Price +"' where Title = '" + Title +"';" );
			      statement.executeUpdate("update books set PublisherDate = '" + PublisherDate +"' where Title = '" + Title +"';" );
		    }
		    catch (Exception e) {
			      System.out.print("get data error!");
			      e.printStackTrace();
			    }
			
			 
			 
		
		
		return SUCCESS;
	}

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

	public String getPublisherDate() {
		return PublisherDate;
	}

	public void setPublisherDate(String publisherDate) {
		PublisherDate = publisherDate;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}
}
