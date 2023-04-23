package Task_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VerkhovnaRada {
	private List<Faction> factions = new ArrayList<Faction>();
	private static final VerkhovnaRada INSTANCE = new VerkhovnaRada();

	private VerkhovnaRada() {
	}

	public static VerkhovnaRada getInstance() {
		@SuppressWarnings("unused")
		List<Faction> factions = new ArrayList<Faction>();
		return INSTANCE;
	}

	public void showAllFaction() {
		for (Faction f : factions) {
			System.out.println("Фракція " + f.getFactionName());
		}
	}

	public void addFaction(String name) {
		factions.add(new Faction(name));
	}

	public void removeFaction(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				iterator.remove();
				System.out.println("Фракція " + next.getFactionName() + " видалена");
			}
		}
	}

	public void addDeputyToFaction(String name, int weight, int height, String firstName, String lastName, int age,
			boolean bribetaker) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				next.addDeputy(weight, height, firstName, lastName, age, bribetaker);
			}
		}
	}

	public void showAllDeputyFromFaction(String name) {

		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("Фракція " + name + ":");
				next.showAllDeputies();
			}
		}
	}

	public void showAllBribetakersFromFaction(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("Фракція " + name + ":");
				next.showAllBribetakers();
			}
		}
	}

	public void showAllBribetakers() {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			next.showAllBribetakers();
		}
	}

	public void giveBribe(String name, int value) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			next.giveBribe(name, value);
		}
	}

	public Deputy showMostBribetakerFromFaction(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				System.out.println("Фракція " + name + ":");
				return next.showMostBribetaker();
			}
		}
		return null;
	}

	public void showMostBribetaker() {
		int count = 0;
		List<Deputy> allDeputiesBribetakers = new ArrayList<Deputy>();
		Iterator<Faction> iterator = factions.iterator();
		Deputy mostBribetaker = null;
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.showMostBribetaker() != null)
				allDeputiesBribetakers.add(next.showMostBribetaker());
		}
		Iterator<Deputy> iterator1 = allDeputiesBribetakers.iterator();
		while (iterator1.hasNext()) {
			Deputy next = iterator1.next();
			int bribe = next.getBribeValue();
			if (bribe >= count) {
				count = bribe;
				mostBribetaker = next;
			}
		}
		if (count > 0) {
			System.out.println("Депутат: " + mostBribetaker.getFirstName() + " " + mostBribetaker.getLastName()
					+ ", Розмір хабаря:" + mostBribetaker.getBribeValue());
		}
	}

	public void clearFaction(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				next.clearFaction();
			}
		}
		System.out.println("Всі депутати з фракції " + name + " видалені");
	}

	public void deleteAllFactions() {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			iterator.remove();
		}
		System.out.println("Всі фракції видалені");
	}

	public void removeDeputy(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			next.removeDeputy(name);
		}
	}

	public void showAllDeputies() {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			next.showAllDeputies();
		}
	}
	public boolean isFactionPresent(String name) {
		Iterator<Faction> iterator = factions.iterator();
		while (iterator.hasNext()) {
			Faction next = iterator.next();
			if (next.getFactionName().toLowerCase().equals(name.toLowerCase())) {
				return true;
			}
		}
		System.out.println("Такої фракції не існує");
		return false;
		
	}

}
