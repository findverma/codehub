
package practice.findverma.codehub.solid_principle.l.problem;

import java.util.Arrays;
import java.util.List;

interface Persistence {
	public void load();

	public void persist();
}

class UserSetting implements Persistence {
	@Override
	public void load() {
		System.out.println("UserPersist Load calls");
	}

	@Override
	public void persist() {
		System.out.println("UserPersist persist calls");
	}
}

class ApplicationSetting implements Persistence {
	@Override
	public void load() {
		System.out.println("ApplicationSetting Load calls");
	}

	@Override
	public void persist() {
		System.out.println("ApplicationSetting persist calls");
	}
}

class AdditionSetting implements Persistence {

	@Override
	public void load() {
		System.out.println("AdditionSetting Load calls");
	}

	@Override
	public void persist() {
		throw new UnsupportedOperationException();
	}
}

public class LiskovProblem {

	private static List<Persistence> persistenceList() {
		return Arrays.asList(new Persistence[] { new UserSetting(), new ApplicationSetting(),
				// new AdditionSetting() // It will violate the principle
		});
	}

	private static void displaySettings(List<Persistence> settings) {
		// forEach() method works fine if settings list contains only
		// UserSetting and ApplicationSetting.
		// If I add AdditionalSetting in list then this method violates the
		// Liskov principle.
		// one solution is use instanceof before persist() calls
		settings.forEach((persistence) -> {
			//if (!(persistence instanceof AdditionSetting)) // call only if persistence in not an instance of AdditionSetting class
			persistence.persist();
			persistence.load();
		});
	}

	public static void main(String[] args) {
		List<Persistence> settings = persistenceList();
		displaySettings(settings);
	}

}
