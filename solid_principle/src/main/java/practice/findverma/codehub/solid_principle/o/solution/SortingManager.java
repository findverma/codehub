package practice.findverma.codehub.solid_principle.o.solution;

import java.util.List;

public class SortingManager {

	// Here you don't need to modify the code if new sorting approach has introduced.
	// You just have to create XXXSort class , implements Sorter interface 
	// and pass the implementation class object to this method.
	public static void sort(Sorter sorter, List<String> collection){
		sorter.sort(collection);
	}
}
