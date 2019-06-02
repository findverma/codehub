package practice.findverma.codehub.solid_principle.s.solution;

import java.util.List;

// this persistence API could further improved. for example save in different format(pdf, doc etc.) 
public interface BookPersistence {
	public void save(Book book);
	public void saveAll(List<Book> books);
}
