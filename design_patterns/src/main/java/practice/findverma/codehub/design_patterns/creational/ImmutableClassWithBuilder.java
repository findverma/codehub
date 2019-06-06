package practice.findverma.codehub.design_patterns.creational;

import java.util.HashMap;

public final class ImmutableClassWithBuilder {
	//All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional 
    private final HashMap<String, String> properties; // optional
    
    private ImmutableClassWithBuilder(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age; 
        // Deep copy of mutable objects
        HashMap<String,String> tempMap=new HashMap<>();
        builder.properties.entrySet().stream().forEach((e)-> {
			tempMap.put(e.getKey(), e.getValue());
		});
		this.properties=tempMap;
    }

    //Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public HashMap<String, String> getProperties() {
		return (HashMap<String, String>) properties.clone(); // Return clone copy or immutable map.
	}
	
	
	public static class UserBuilder
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private HashMap<String,String> properties;
 
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder properties(HashMap<String,String> properties) {
            this.properties = properties;
            return this;
        }
        //Return the finally consrcuted User object
        public ImmutableClassWithBuilder build() {
        	ImmutableClassWithBuilder immutable =  new ImmutableClassWithBuilder(this);
            return immutable;
        }
    }
    
    
    
}
