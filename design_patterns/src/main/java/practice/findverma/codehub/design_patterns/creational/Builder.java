package practice.findverma.codehub.design_patterns.creational;
/*
 	The builder pattern is an alternative way to construct complex objects. 
 	This should be used only when :
 		1. Complex constructor:		
 				Multiple constructor having combinations of multiple parameter with nested objects
		2. Large number of parameters: 
				having large number of field parameter is also the key point to consider.
		3. Immutability: 
				You can force the immutability to the object once you are done with creation of object. 
 */
class User
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
 
    private User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }
 
    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address;
    }
 
    public static class UserBuilder
    {
        private final String firstName;
        private final String lastName;
        private int age;
        private String phone;
        private String address;
 
        public UserBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }
        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }
        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }
        //Return the finally consrcuted User object
        public User build() {
            User user =  new User(this);
            validateUserObject(user);
            return user;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}


public class Builder {
	public static void main(String[] args) {
	    User user1 = new User.UserBuilder("Shailendra", "Verma")
	    .age(30)
	    .phone("1234567")
	    .address("address 1234")
	    .build();
	 
	    System.out.println(user1);
	 
	    User user2 = new User.UserBuilder("Vikas", "Balani")
	    .age(40)
	    .phone("5655")
	    //no address
	    .build();
	 
	    System.out.println(user2);
	}
}