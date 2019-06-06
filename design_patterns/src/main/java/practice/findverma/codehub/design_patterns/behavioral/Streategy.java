package practice.findverma.codehub.design_patterns.behavioral;
/* 
 	Strategy design pattern,  where we choose a specific implementation-type in run time from multiple other implementations for supertype.
 	The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. Strategy lets the algorithm vary independently from the clients that use it
	For example: validate behavior at runtime for each entity(Country, Currency, Uom etc )
 */

import java.util.List;

class Entity{}

class Country extends Entity{
	//fields	
}
class Language extends Entity{
	//fields	
}


interface Validator{
	public boolean validate(List<Entity> data);
}
class CountryValidator implements Validator{
	@Override
	public boolean validate(List<Entity> data) {
		System.out.println("Validating Country Records... ");
		return true;
	}
}
class LanguageValidator implements Validator{
	@Override
	public boolean validate(List<Entity> data) {
		System.out.println("Validating Language Records... ");
		return true;
	}
	
}

public class Streategy {

	public static void main(String[] args) {
		createEntity("Language", "[{...},{...},{...}]");
		createEntity("Country", "[{...},{...},{...}]");
	}

	private static void createEntity(String entityType, String entityData) {
		
		Validator validator = getValidator(entityType); // This code works fine for all Validators. You don't have to change the code if new validator added
		if(!isValidateEntity(validator, entityData)){
			throw new  RuntimeException();
		}
		
	}

	private static boolean isValidateEntity(Validator validator, String entityData) {
		List<Entity> listData = parseEntityData(entityData); 
		return validator.validate(listData);
	}

	private static List<Entity> parseEntityData(String entityData) {
		// TODO Auto-generated method stub
		return null;
	}

	// This method is just for Object creation like factory pattern. It could be improved with reflection API.
	private static Validator getValidator(String entityType) {
		if("Language".equals(entityType))
			return new LanguageValidator();
		else if("Country".equals(entityType))
			return new CountryValidator();
		else return null;
	}


}
