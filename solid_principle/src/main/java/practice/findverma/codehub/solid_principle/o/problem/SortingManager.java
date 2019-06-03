package practice.findverma.codehub.solid_principle.o.problem;

import java.util.List;

public class SortingManager {

	// Problem is here , If new sort approach is introduced 
	// then this method has to be modified and SortType enum has to be modified. 
	//It violates the Open-CLose Principle.
	public static void sort(SortType sortType , List<String> collection){
		switch (sortType) {
		case BUBBLE_SORT:
			new BubbleSort().sort(collection);
			break;
		case INSERTION_SORT:
			new InsertionSort().sort(collection);
			break;
		case SELECTION_SORT:
			new SelectionSort().sort(collection);
			break;
		}
	}
}
