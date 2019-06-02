package practice.findverma.codehub.solid_principle.o.problem;

import java.util.List;

public class BubbleSort extends Sorter {

	public BubbleSort() {
		this.sortType = SortType.BUBBLE_SORT;
	}
	@Override
	public void sort(List<String> collection) {
		System.out.println("Sorting with Bubble sort ... "+collection);
	}

}
