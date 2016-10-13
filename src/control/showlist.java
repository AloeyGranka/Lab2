package control;
import thing.books;
import java.sql.*;


public class showlist {
	private books allbooks[];

  public String execute() throws Exception{
	     
	    try {
	      Class.forName("com.mysql.jdbc.Driver");     //����MYSQL JDBC��������   
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
	           //����URLΪ   jdbc:mysql//��������ַ/���ݿ���  �������2�������ֱ��ǵ�½�û���������
	      System.out.println("Success connect Mysql server!");
	      Statement stmt = connect.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from books");
	                                                              //user Ϊ��������
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