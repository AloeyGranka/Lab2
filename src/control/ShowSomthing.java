package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ShowSomthing extends ActionSupport{
	private String Title,ISBN,AuthorID,Publisher,PublisherDate,Price;
	private String name,country,AGE;
	private int age;
	
	
	public String execute()  {
		  try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    String ID = null;
		    try {
		      Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/book","root","aloey25800258");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      int count = 0; 
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery("select * from books where Title='"+Title+"'");
		                                                              //user 为你表的名称
		      while (rs.next()) {
		    	  AuthorID=rs.getString("AuthorID");
		    	  ISBN=rs.getString("ISBN");
		    	  Title=rs.getString("Title");
		    	  Publisher=rs.getString("Publisher");
		    	  PublisherDate=rs.getString("Publisherdate");
		    	  Price=rs.getString("Price");

		          count = rs.getInt(1); 
		          ID=rs.getString("AuthorID");
		        }
		  	if (count == 0 )
		  	{
		  		System.out.println("没有这本书！"); 
		  	}
		  	else
		  	{
		  		Connection connect2 = DriverManager.getConnection(
		  	          "jdbc:mysql://localhost:3306/author","root","aloey25800258");
		  	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

		  	      Statement stmt2 = connect2.createStatement();
		  	      ResultSet rs2 = stmt2.executeQuery(" select * from authors where authorID='"+ID+"'");
		  	      while (rs2.next()) {
		  	    	  name=rs2.getString("name");
		  	    	  AuthorID=rs2.getString("authorID");
		  	    	  age=rs2.getInt("age");
		  	    	  country=rs2.getString("country");
		  	        }
		  	}  
		    }
		    
		    catch (Exception e) {
		      System.out.print("get data error!");
		      e.printStackTrace();
		    }
		    AGE=String.valueOf(age);
		return SUCCESS;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
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


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getAGE() {
		return AGE;
	}


	public void setAGE(String aGE) {
		AGE = aGE;
	}
}
