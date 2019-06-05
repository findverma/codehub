package practice.findverma.codehub.solid_principle.d.problem;
/*
 		DEPENDENCY INVERSION PRINCIPLE (Also called inversion of control)
 	.........................................................................
 		
 		High level modules should not  depend on low level module.
 		We have to use abstraction layer between both. Both should depend on abstraction.
 		
 		 HIGH-LEVEL MODULES <---> ABSTRACTION LAYER (INTERFACES) <---> LOW-LEVEL MODULE
  		
  		Here Abstraction layer should not dependent on details.
  
  
  	We should avoid creating tightly coupled code in a class.
  	For example:
  	 creating an object with new keyword results a class tightly coupled with another class.
  	 public class Employee{
  	 	private Address address;
  	 	Employee(){
  	 		this.address = new Address();  // Tightly coupled dependency
  	 	}
  	 }
  	 
  	 Above example High-Level-Module(Employee) is dependent on Low-Level-Module(Address). This is the violation of DIP.
  
  	Dependency Inversion Principle(DIP) helps us to create loosely coupled software-modules. So that at runtime you can changes it easily.
  	In OOPs, We can implement DIP with following ways:
  		1. using design patterns FACTORY, STREATGY Etc
  		2. using SERVICE-LOCATOR 
  		3. Using Dependency injection with the help of 
  
*/

class MySqlDatabse{
	public void connect(){System.out.println("Connecting with MySql Server ...");}
	public void disconnect(){System.out.println("Disconnecting from MySql Server ...");}
}

// High level module (DatabseHandler) which is tightly dependent on low-level module (MySqlDatabse). 
// Problem occurs when you are required to change DB server from mySql to Oracle.
// Here you a violating two SOLID principle
// 	1. DIP because (DatabseHandler) which is tightly dependent on (MySqlDatabse)
// 	2. Open-Close principle if you modify this class and add Oracle database connection object.

// 	
class DatabseHandler{
	private MySqlDatabse mySqlDatabse;
	public DatabseHandler() {
		mySqlDatabse = new MySqlDatabse();  
	}
	public void getConnection(){mySqlDatabse.connect();}
	public void releaseConnect(){mySqlDatabse.disconnect();}
}


public class DependencyInversionProbem {

	public static void main(String[] args) {
		DatabseHandler handler  = new DatabseHandler();
		handler.getConnection();
		handler.releaseConnect();
	}

}
