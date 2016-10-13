package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Addauthor extends ActionSupport{
	private String name,AuthorID,age,country;


	public String getAuthorID() {
		return AuthorID;
	}


	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}
	
	public String execute() throws Exception {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	        //Class.forName("org.gjt.mm.mysql.Driver");
	       //System.out.println("Success loading Mysql Driver!");
	      }
	      catch (Exception e) {
	        //System.out.print("Error loading Mysql Driver!");
	        e.printStackTrace();
	      }
	      int AGE=Integer.parseInt(age);
	      try {
	        Connection connect = DriverManager.getConnection(
	            "jdbc:mysql://localhost:3306/author","root","aloey25800258");
	             //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	       // System.out.println("Success connect Mysql server!");
	        int i=0;  
	        String sql="insert into authors(authorID,name,age,country) values(?,?,?,?)";                                                          //user 为你表的名称
	        PreparedStatement preStmt = connect.prepareStatement(sql);
	        preStmt.setString(1,AuthorID);
	        preStmt.setString(2,name);
	        preStmt.setInt(3,AGE);
	        preStmt.setString(4,country);

	        i=preStmt.executeUpdate(); 
	        if (i==1)
	        {
	      	  System.out.print("新增成功！");
	        }
	   
	        
	      }
	      catch (Exception e) {
	        System.out.print("get data error!");
	        e.printStackTrace();
	      }
	      return SUCCESS;
	}

}

