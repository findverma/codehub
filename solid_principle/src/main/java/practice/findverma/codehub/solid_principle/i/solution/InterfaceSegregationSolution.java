package practice.findverma.codehub.solid_principle.i.solution;

interface MyNavigableSet<E> {
	   E ceiling(E e);
	   E floor(E e);
	} 

interface MySet<E> {
	   boolean add(E e);
	   boolean contains(Object o);  
	}

class TreeSet implements MySet,MyNavigableSet{

	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Object ceiling(Object e) {
		return null;
	}

	@Override
	public Object floor(Object e) {
		return null;
	}
	
}

class HashSet implements MySet{
	@Override
	public boolean add(Object e) {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}
}
public class InterfaceSegregationSolution {

	private static void desplaySets(MySet<String> mySets){
		mySets.add("A");
		mySets.contains("A");
	}
	
	private static void desplayNavigableSets(MyNavigableSet<String> myNavSets){
		myNavSets.ceiling("A");
		myNavSets.floor("A");
	}
	public static void main(String[] args) {
		desplaySets(new HashSet());
		desplaySets(new TreeSet());
		
		desplayNavigableSets(new TreeSet());

	}

}
