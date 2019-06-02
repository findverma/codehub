package practice.findverma.codehub.solid_principle.s.problem;

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

	// This method violate the SOLID principle.It serves two purpose and this method is 
	// tightly coupled with this class. So there are two reason for this class to change:
	// 1. If save function needs to be changed
	// 2. If print function needs to be changed
	public void saveAndPrint(){
		System.out.println("Saving book ........."+this);
		System.out.println("Printing book ........."+this);
	}
	

}
