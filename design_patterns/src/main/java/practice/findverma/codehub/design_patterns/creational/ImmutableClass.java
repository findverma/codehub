package practice.findverma.codehub.design_patterns.creational;

import java.util.HashMap;

/*
 	To create an immutable class in java, you have to do following steps:

		1. Declare the class as final so it can’t be extended.
		2. Make all fields private so that direct access is not allowed.
		3. Don’t provide setter methods for variables
		4. Make all mutable fields final so that it’s value can be assigned only once.
		5. Initialize all the fields via a constructor (Make sure to use clone copy(performing deep copy) of passed arguments.
		6. Perform cloning of objects in the getter methods to return a copy rather than returning the actual object reference.
*/
public final class ImmutableClass {

	private final int id;
	private final String name;
	private final HashMap<String, Object> testMap;
	
	public ImmutableClass(int i, String n, HashMap<String,String> hm){
		System.out.println("Performing Deep Copy for Object initialization");
		this.id=i;
		this.name=n;
		HashMap<String,Object> tempMap=new HashMap<>();
		hm.entrySet().stream().forEach((e)-> {
			tempMap.put(e.getKey(), e.getValue());
		});
		this.testMap=tempMap;
	}
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public HashMap<String, String> getTestMap() {
		//return testMap;
		return (HashMap<String, String>) testMap.clone(); // Return clone copy or immutable map.
	}
}
