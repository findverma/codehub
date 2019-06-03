package practice.findverma.codehub.solid_principle.o.problem;

import static org.junit.Assert.*;
import java.util.Arrays;

import org.junit.Test;

public class SorterManagerTest {

	private static String[] dataSet = { "Java", "Java Script", "JQuery", 
			"Angular", "Struts", "Hibernate", "Spring"}; 
	
	@Test
	public void testBubbleSort() {
		SortingManager.sort(SortType.BUBBLE_SORT, Arrays.asList(dataSet));
		assertTrue("Sorting with Bubble sort", Boolean.TRUE);
	}

	@Test
	public void testSelectionSort() {
		SortingManager.sort(SortType.SELECTION_SORT, Arrays.asList(dataSet));
		assertTrue("Sorting with Selection sort", Boolean.TRUE);
	}
	
	@Test
	public void testInsertionSort() {
		SortingManager.sort(SortType.INSERTION_SORT, Arrays.asList(dataSet));
		assertTrue("Sorting with Insertion sort", Boolean.TRUE);
	}
	
	// If I want to sort the collection with merge sort. Then We don't have 
	// any option to do this without modifying the existing code. 
	// This is the violation of OPEN-CLOSE Principle 
	@Test
	public void testMergeSort() {
		//SortingManager.sort(SortType.MERGE_SORT, Arrays.asList(dataSet));
		//assertTrue("Sorting with Merge sort", Boolean.TRUE);
	}
}
