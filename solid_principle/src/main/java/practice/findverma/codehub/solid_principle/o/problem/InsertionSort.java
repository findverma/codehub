package practice.findverma.codehub.solid_principle.o.problem;

import java.util.List;

public class InsertionSort extends Sorter{

	public InsertionSort() {
		this.sortType = SortType.INSERTION_SORT;
	}
	@Override
	public void sort(List<String> collection) {
		System.out.println("Sorting with insertion sort"+collection);
	}

}
