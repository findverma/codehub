package practice.findverma.codehub.solid_principle.o.problem;

import java.util.List;

public class SelectionSort extends Sorter {

	public SelectionSort() {
		this.sortType = SortType.SELECTION_SORT;
	}
	@Override
	public void sort(List<String> collection) {
		System.out.println("Sorting with Selection Sort"+collection);
	}

}
