package practice.findverma.codehub.design_patterns.creational;

public class SingletonViolationCloneable {
	
	private static SingletonViolationCloneable instance;

    private SingletonViolationCloneable() {}

    public static synchronized SingletonViolationCloneable getInstance() {
        if(instance == null) {
            instance = new SingletonViolationCloneable();
        }
        return instance;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException  
    { 
      throw new CloneNotSupportedException(); 
    } 
}
