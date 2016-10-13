package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Update extends ActionSupport{
	private String ISBN,Title,AuthorID,PublisherDate,Price,Publisher;
	
	
	public String execute() throws Exception {
	        Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
	        //Class.forName("org.gjt.mm.mysql.Driver")
	        Connection connect = DriverManager.getConnection(
	            "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
	             //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
	        int i=0;                                                          //user Ϊ��������
	        String sql="update books set ISBN=?,AuthorID=?,Publisher=?,Publisherdate=?,Price=?  where Title='"+Title+"'";
	        PreparedStatement preStmt =connect.prepareStatement(sql);  
	        preStmt.setString(1,ISBN);  
	        preStmt.setString(2,AuthorID);//���ߣ�preStmt.setInt(1,ֵ);  
	        preStmt.setString(3,Publisher);  
	        preStmt.setString(4,PublisherDate);  
	        preStmt.setString(5,Price);//���ߣ�preStmt.setInt(1,ֵ);      
	        i=preStmt.executeUpdate(); 
	        
	        if (i==1)
	        {
	      	  System.out.print("���ĳɹ���");
	        }
	   
	        
	        
	        
		
		
		
		return SUCCESS;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPublisher() {
		return Publisher;
	}


	public void setPublisher(String Publisher) {
		ISBN = Publisher;
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

