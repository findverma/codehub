package practice.findverma.codehub.design_patterns.creational;

public class EagerSingleton {

    /* private constructor to prevent others from instantiating this class.
       Also you can not extends this class.
       There are two ways to stop inheritance in class:
       	1. mark class as final
       	2. mark constructor as private
 	*/
    private EagerSingleton() { }
    private static final EagerSingleton instance = new EagerSingleton();
    public static EagerSingleton getInstance() {
        return instance;
    }
}