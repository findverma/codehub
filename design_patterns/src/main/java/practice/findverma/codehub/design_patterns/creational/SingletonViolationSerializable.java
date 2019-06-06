package practice.findverma.codehub.design_patterns.creational;

import java.io.Serializable;

public class SingletonViolationSerializable implements Serializable {
	
    private static final long serialVersionUID = 8806820726158932906L;

    private static SingletonViolationSerializable instance;

    private SingletonViolationSerializable() {}

    public static synchronized SingletonViolationSerializable getInstance() {
        if(instance == null) {
            instance = new SingletonViolationSerializable();
        }
        return instance;
    }

    // implement readResolve method to return the existing instance
    protected Object readResolve() {
        return instance;
    }

}
