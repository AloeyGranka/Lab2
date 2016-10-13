package action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class Updateshow extends ActionSupport{
	private String ISBN,Title,AuthorID,Publisher,PublishDate,Price; 	
	public String execute() throws Exception {

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


	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
}

