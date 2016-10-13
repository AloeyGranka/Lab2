package action;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opensymphony.xwork2.ActionContext;
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
	public String detectNoAuthor() {
		ActionContext context = ActionContext.getContext();
		AuthorID = (String) context.getSession().get("AuthorID");
		return SUCCESS;
	}
	
	public String execute() throws Exception {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
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
	            "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
	             //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
	       // System.out.println("Success connect Mysql server!");
	        int i=0;  
	        String sql="insert into authors(authorID,name,age,country) values(?,?,?,?)";                                                          //user Ϊ��������
	        PreparedStatement preStmt = connect.prepareStatement(sql);
	        preStmt.setString(1,AuthorID);
	        preStmt.setString(2,name);
	        preStmt.setInt(3,AGE);
	        preStmt.setString(4,country);

	        i=preStmt.executeUpdate(); 
	        if (i==1)
	        {
	      	  System.out.print("�����ɹ���");
	        }
	   
	        
	      }
	      catch (Exception e) {
	        System.out.print("get data error!");
	        e.printStackTrace();
	      }
	      return SUCCESS;
	}

}

