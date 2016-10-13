package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;


@SuppressWarnings("serial")
public class FindBookByAuthor extends ActionSupport{
	private String name;
	private String Price;
	private String ISBN;
	private String AuthorID;
	private String Title;
	private String Publisher;
	private String Publish_date;
	
	
	@SuppressWarnings("rawtypes")
	public String execute() throws Exception {
		
		  String ID = null; 
		    try {
		      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    
		    Connection connect = DriverManager.getConnection(
		          "jdbc:mysql://localhost:3306/author","root","aloey25800258");
		           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
		      Statement stmt = connect.createStatement();
		      ResultSet rs = stmt.executeQuery(" select * from authors where name='"+name+"'");
		      //user 为你表的名称
		 
		      while (rs.next()) {
		    	  ID=rs.getString("authorID");
		      }
		  	Connection connect2 = DriverManager.getConnection(
			          "jdbc:mysql://localhost:3306/book","root","aloey25800258");
			           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码

			      System.out.println("Success connect Mysql server!");
			      Statement stmt2 = connect2.createStatement();
			      ResultSet rs2 = stmt2.executeQuery(" select * from books where AuthorID='"+ID+"'");
			  	ArrayList<FindBookByAuthor> books = new ArrayList<FindBookByAuthor>();
				while (rs2.next()) {
					FindBookByAuthor b=new FindBookByAuthor();
					b.setTitle(rs2.getString("Title"));
					b.setISBN(rs2.getString("ISBN"));
					b.setPrice(rs2.getString("Price"));
					b.setPublish_date(rs2.getString("Publisherdate"));
					b.setPublisher(rs2.getString("Publisher"));
					b.setAuthorID(rs2.getString("AuthorID"));
					
					books.add(b);
				}
		      
				ValueStack stack = ActionContext.getContext().getValueStack();
				Map context = new HashMap();
				if(books.size() != 0){
					context.put("Books", books);
					context.put("empty", 0);
				}
				else{
					context.put("empty", 1);
				}
				stack.push(context);
				//关闭相应链接
			    stmt2.close();
			    rs2.close();
		      
		return SUCCESS;
	}
	


	
	
	
	
	
	
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPrice() {
		return Price;
	}



	public void setPrice(String price) {
		Price = price;
	}



	public String getISBN() {
		return ISBN;
	}



	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}



	public String getAuthorID() {
		return AuthorID;
	}



	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}



	public String getTitle() {
		return Title;
	}



	public void setTitle(String title) {
		Title = title;
	}



	public String getPublisher() {
		return Publisher;
	}



	public void setPublisher(String publisher) {
		Publisher = publisher;
	}



	public String getPublish_date() {
		return Publish_date;
	}



	public void setPublish_date(String publish_date) {
		Publish_date = publish_date;
	}
}

