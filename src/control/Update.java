package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Update extends ActionSupport{
	private String ISBN,Title,AuthorID,Publisher,PublisherDate,Price;
	
	
	public String execute() throws Exception {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
	        //Class.forName("org.gjt.mm.mysql.Driver")
	      }
	      catch (Exception e) {
	        e.printStackTrace();
	      }
	      try {
	        Connection connect = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/book","root","aloey25800258");
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


	public String getPublihsher() {
		return Publisher;
	}


	public void setPublihsher(String publihsher) {
		Publisher = publihsher;
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

