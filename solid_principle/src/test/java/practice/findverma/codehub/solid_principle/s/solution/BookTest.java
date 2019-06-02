package practice.findverma.codehub.solid_principle.s.solution;

import static org.junit.Assert.*;

import org.junit.Test;

import practice.findverma.codehub.solid_principle.s.solution.Book;

public class BookTest {

	@Test
	public void saveTest() {
		Book book = new Book(300, "Java 8 In Action", "Mario Fusco");
		book.save();
		assertTrue("save() successfully executed", Boolean.TRUE);
	}
	
	@Test
	public void printTest() {
		Book book = new Book(300, "Java 8 In Action", "Mario Fusco");
		book.print();
		assertTrue("print() successfully executed", Boolean.TRUE);
	}

}
