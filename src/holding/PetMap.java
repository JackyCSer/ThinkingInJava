package holding;

import java.util.*;

import typeinfo.pets.*;

public class PetMap
{
	public static void main(String [] args)
	{
		Map<String, Pet> petMap = new HashMap<String, Pet>();
		petMap.put("My Cat", new Cat("Molly"));
		petMap.put("My Dog", new Dog("Giner"));
		petMap.put("My Hamseter", new Hamster("Bosco"));
		System.out.println(petMap);
		Pet dog = petMap.get("My Dog");
		System.out.println(petMap.containsKey("My Dog"));
		System.out.println(petMap.containsValue(dog));
	}
}
