package action;

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
public class Showbook2 extends ActionSupport{
	private String price;
	private String ISBN;
	private String authorid;
	private String title;
	private String publisher;
	private String publish_date;
	
	
	@SuppressWarnings("rawtypes")
	public String execute() throws SQLException, Exception{
		 //��ȡ����
		 try {
		      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
		      //Class.forName("org.gjt.mm.mysql.Driver");
		    // System.out.println("Success loading Mysql Driver!");
		    }
		    catch (Exception e) {
		      //System.out.print("Error loading Mysql Driver!");
		      e.printStackTrace();
		    }
		    
		Connection conn = DriverManager.getConnection(
		          "jdbc:mysql://meyjjvhnbnhx.rds.sae.sina.com.cn:10578/book","root","aloey25800258");
		String sql="SELECT * FROM book.books";
		Statement ptmt=conn.createStatement();
		ResultSet rs=ptmt.executeQuery(sql);
		ArrayList<Showbook2> books = new ArrayList<Showbook2>();
		while (rs.next()) {
			Showbook2 b=new Showbook2();
			b.setTitle(rs.getString("Title"));
			b.setISBN(rs.getString("ISBN"));
			b.setPrice(rs.getString("Price"));
			b.setPublish_date(rs.getString("Publisherdate"));
			b.setPublisher(rs.getString("Publisher"));
			b.setAuthorid(rs.getString("AuthorID"));
			
			books.add(b);
		}
		//���ؽ����Ϊ�գ��򽫻�õ�����ѹ��ֵջ
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
		//�ر���Ӧ����
	   // ptmt.close();
	    //rs.close();
		return SUCCESS;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAuthorid() {
		return authorid;
	}

	public void setAuthorid(String authorid) {
		this.authorid = authorid;
	}


	
}
