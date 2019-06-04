/*	L-> LISKOV SUBSTITUTION
	
	......................................................................................
		Solution of Lisov violation:
		1. Modify the existing code and use instanceof operator to check subtype before method call that throws exception.
		2. Re design the interface with the help of interface segregation principle
		3. use composition (HAS-A) and decorator pattern to solve this problem
		
*/
package practice.findverma.codehub.solid_principle.l.solution;

import java.util.Arrays;
import java.util.List;

interface Persistence {
	public void persist();
}

interface Load {
	public void load();
}

class UserSetting implements Persistence, Load {
	@Override
	public void load() {
		System.out.println("UserPersist Load calls");
	}

	@Override
	public void persist() {
		System.out.println("UserPersist persist calls");
	}
}

class ApplicationSetting implements Persistence, Load {
	@Override
	public void load() {
		System.out.println("ApplicationSetting Load calls");
	}

	@Override
	public void persist() {
		System.out.println("ApplicationSetting persist calls");
	}
}

class AdditionSetting implements Load {
	@Override
	public void load() {
		System.out.println("AdditionSetting Load calls");
	}

}

public class LiskovSolution {

	private static List<Load> loadList() {
		return Arrays.asList(new Load[] { new UserSetting(), new ApplicationSetting(), new AdditionSetting() });
	}
	private static List<Persistence> persistenceList() {
		return Arrays.asList(new Persistence[] { new UserSetting(), new ApplicationSetting()});
	}

	private static void displayPersistence(List<Persistence> settings) {
		settings.forEach((persistence) -> {
			persistence.persist();
		});
	}

	private static void displayLoad(List<Load> settings) {
		settings.forEach((load) -> {
			load.load();
		});
	}

	public static void main(String[] args) {
		displayPersistence(persistenceList());
		displayLoad(loadList());
	}

}
