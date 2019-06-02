package practice.findverma.codehub.solid_principle.s.solution;

import java.util.List;

public class BookPersistenceImpl implements BookPersistence{

	public void save(Book book) {
		System.out.println("Saving Book"+ book);
	}

	public void saveAll(List<Book> books) {
		
		books.forEach((book)->{save(book);});
	}

}
