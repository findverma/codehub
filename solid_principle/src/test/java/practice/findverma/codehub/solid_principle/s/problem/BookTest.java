package practice.findverma.codehub.solid_principle.s.problem;

import static org.junit.Assert.*;

import org.junit.Test;

public class BookTest {

	@Test
	public void saveAndPrintTest() {
		Book book = new Book(300, "Java 8 In Action", "Mario Fusco");
		book.saveAndPrint();
		assertTrue("saveAndPrint() successfully executed", Boolean.TRUE);
	}

}
