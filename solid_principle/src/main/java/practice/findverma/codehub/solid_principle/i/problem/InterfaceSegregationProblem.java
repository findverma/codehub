/*
	INTERFACE SEGREGATION PRINICPLE
	
	What is the motivation behind this?
	Sometime we want to implement the interface to define some methods but we have to implement all the methods of this fat-interface.
	
	- It is not good to have lots of methods in interface. We should keep them separately.
	- This separation of concern is ISP.
	- ISP state then no client should be force to depend on the methods that it does not use.
	
	We should break the interface into multiple smaller interfaces.
	
*/
package practice.findverma.codehub.solid_principle.i.problem;

interface MySet<E> {
	boolean add(E e);
	boolean contains(Object o);
	E ceiling(E e);   // this method is violating the implementation for HashSet
	E floor(E e);	// this method is violating the implementation for HashSet
}

class TreeSet<E> implements MySet<E> {
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E ceiling(E e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E floor(E e) {
		// TODO Auto-generated method stub
		return null;
	}
}

class HashSet<E> implements MySet<E> {
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E ceiling(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E floor(E e) {
		throw new UnsupportedOperationException();
	}
}

public class InterfaceSegregationProblem {

	// this method will throw exception for type HashSet<E> because it does not support ceiling and floor method.
	// This method violates two principle 1. LIskov and 2. ISP
	public static void desplaysSets(MySet<String> mySets){   
		mySets.add("A");
		mySets.ceiling("A");
		mySets.ceiling("A");
		mySets.floor("A");
	}
	public static void main(String[] args) {
		desplaysSets(new TreeSet<String>());
		desplaysSets(new HashSet<String>());
	}

}
