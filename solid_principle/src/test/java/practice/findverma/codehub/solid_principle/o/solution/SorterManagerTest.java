package practice.findverma.codehub.solid_principle.o.solution;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import practice.findverma.codehub.solid_principle.o.solution.SortingManager;

public class SorterManagerTest {

	private static String[] dataSet = { "Java", "Java Script", "JQuery", 
			"Angular", "Struts", "Hibernate", "Spring"}; 
	
	@Test
	public void testBubbleSort() {
		SortingManager.sort(new BubbleSort(), Arrays.asList(dataSet));
		assertTrue("Sorting with Bubble sort", Boolean.TRUE);
	}

	@Test
	public void testSelectionSort() {
		SortingManager.sort(new SelectionSort(), Arrays.asList(dataSet));
		assertTrue("Sorting with Selection sort", Boolean.TRUE);
	}
	
	@Test
	public void testInsertionSort() {
		SortingManager.sort(new InsertionSort(), Arrays.asList(dataSet));
		assertTrue("Sorting with Insertion sort", Boolean.TRUE);
	}
	
	// If I want to sort the collection with merge sort. Then We don't need to modify the 
	// existing code . Just create new sorter implementation and pass as argument
	@Test
	public void testMergeSort() {
		Sorter mergeSort = new Sorter() {
			@Override
			public void sort(List<String> collection) {
				System.out.println("Sorting with merge sort "+collection);
			}
		};
		SortingManager.sort(mergeSort, Arrays.asList(dataSet));
		assertTrue("Sorting with Merge sort", Boolean.TRUE);
	}
}
