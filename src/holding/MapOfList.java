package holding;

import java.util.*;

import typeinfo.pets.*;

public class MapOfList
{
	public static Map<Person, List<? extends Pet>> petPeople = 
			new HashMap<Person, List<? extends Pet>>();
	
	static
	{
		petPeople.put(new Person("Dawn"), 
				Arrays.asList(new Cymric("Molly"), new Mutt("Spot")));
		petPeople.put(new Person("Kate"), 
				Arrays.asList(new Cat("Shackleton"), new Dog("Margrett")));
		
	}
	
	public static void main(String [] args)
	{
		System.out.println("People: " + petPeople.keySet());
		System.out.println("Pets: " + petPeople.values());
		
	}
	
}
