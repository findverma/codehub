package practice.findverma.codehub.design_patterns.creational;
/*   
 	1. throws exception from constructor if instance in not null
 	2. use enum for singleton
 */
public class SingletonViolationByReflection {

    private static final SingletonViolationByReflection instance = new SingletonViolationByReflection();

    private SingletonViolationByReflection() {
        // protect against instantiation via reflection
        if(instance != null) {
            throw new IllegalStateException("Singleton already initialized");
        }
    }

    public static SingletonViolationByReflection getInstance() {
        return instance;
    }
}
