package practice.findverma.codehub.design_patterns.creational;

import java.sql.Connection;
/*
 * This approach has serialization and thread-safety guaranteed by the enum implementation itself, which ensures internally that only the single instance is available.
 * 
 */
public enum SingletonEnum {
	
	INSTANCE;
	
	private Connection connection;
    
	SingletonEnum()
    {
        // Initialize the connection
		//connection = DB.getConnection();
    }
    public Connection getConnection()
    {
        return connection;
    }
    
    public static void main(String[] args) {
		Connection connection = SingletonEnum.INSTANCE.getConnection();
	}
}
