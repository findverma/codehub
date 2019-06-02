package practice.findverma.codehub.solid_principle.s.solution;

public class Book {
	
	private Integer noOfPages;
	private String title;
	private String author;

	public Book(Integer noOfPages, String title, String author) {
		super();
		this.noOfPages = noOfPages;
		this.title = title;
		this.author = author;
	}

	public Integer getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book [noOfPages=" + noOfPages + ", title=" + title + ", author=" + author + "]";
	}

	// the solution is separate out in to two method save() and print()
	// Also delegate the save responsibility to BookPersistance API 
	//so that any changes occur in save . you don't need to modify this save method.
	public void save(){
		//BookPersistance API could be used as composition in this class
		new BookPersistenceImpl().save(this);
	}
	
	public void print(){
		//BookPrint API could be used as composition in this class
		new BookPrintImpl().print(this);
	}
	

}
