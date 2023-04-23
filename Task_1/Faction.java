package Task_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Faction {
	List<Deputy> faction;
	String factionName;

	Faction(String name) {
		factionName = name;
		faction = new ArrayList<Deputy>();
	}

	public void addDeputy(int weight, int height, String firstName, String lastName, int age, boolean bribetaker) {
		faction.add(new Deputy(weight, height, firstName, lastName, age, bribetaker));
	}

	public void giveBribe(String name, int valueOfMoney) {
		Iterator<Deputy> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.getLastName().toLowerCase().equals(name.toLowerCase())) {
				next.giveBribe(valueOfMoney);
			}
		}
	}

	public void showAllDeputies() {
		Iterator<Deputy> iterator = faction.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

	public void showAllBribetakers() {
		Iterator<Deputy> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.isBribetaker()) {
				System.out.println(next);
			}
		}
	}

	public Deputy showMostBribetaker() {
		int count = 0;
		Deputy mostBribetaker = null;
		Iterator<Deputy> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			int bribe = next.getBribeValue();
			if (bribe >= count) {
				count = bribe;
				mostBribetaker = next;
			}
		}
		if (count > 0) {
			return mostBribetaker;
		}
		return null;
	}

	public void clearFaction() {
		while (faction.size() > 0) {
			faction.remove(0);
		}
	}

	public void removeDeputy(String name) {
		Iterator<Deputy> iterator = faction.iterator();
		while (iterator.hasNext()) {
			Deputy next = iterator.next();
			if (next.getLastName().toLowerCase().equals(name.toLowerCase())) {
				iterator.remove();
				System.out.println("Депутат " + next.getLastName() + " " + next.getFirstName() + " був видалений");
			}
		}
	}

	@Override
	public String toString() {
		return "Фракція " + factionName + ", toString()=" + super.toString() + "]";
	}

	public String getFactionName() {
		return factionName;
	}

}
