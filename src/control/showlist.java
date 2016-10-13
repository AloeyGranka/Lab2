package control;
import thing.books;
import java.sql.*;


public class showlist {
	private books allbooks[];

  public String execute() throws Exception{
	     
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //加载MYSQL JDBC驱动程序   
	      //Class.forName("org.gjt.mm.mysql.Driver");
	     System.out.println("Success loading Mysql Driver!");
	    }
	    catch (Exception e) {
	      System.out.print("Error loading Mysql Driver!");
	      e.printStackTrace();
	    }
	    
		try {
	      Connection connect = DriverManager.getConnection(
	          "jdbc:mysql://localhost:3306/book","root","aloey25800258");
	           //连接URL为   jdbc:mysql//服务器地址/数据库名  ，后面的2个参数分别是登陆用户名和密码
	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from books");
	                                                              //user 为你表的名称
	      int number=0;
	    while (rs.next()) {
	    	allbooks[number].setAuthorID(rs.getString("AuthorID"));
	    	allbooks[number].setISBN(rs.getString("ISBN"));
	    	allbooks[number].setTitle(rs.getString("Title"));
	    	allbooks[number].setPublisher(rs.getString("Publisher"));
	    	allbooks[number].setPublisherDate(rs.getString("Publisherdate"));
	    	allbooks[number].setPrice(rs.getString("Price"));
            number++;
	      }
	    }
	    catch (Exception e) {
	      System.out.print("get data error!");
	      e.printStackTrace();
	    }
		return "showstringarray";
	  }

public books[] getAllbooks() {
	return allbooks;
}

public void setAllbooks(books allbooks[]) {
	this.allbooks = allbooks;
}


}