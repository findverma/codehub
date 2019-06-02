package practice.findverma.codehub.solid_principle.s.solution;

public class BookPrintImpl implements BookPrint{

	@Override
	public void print(Book book) {
		System.out.println("Printing Book "+ book);
	}

}
