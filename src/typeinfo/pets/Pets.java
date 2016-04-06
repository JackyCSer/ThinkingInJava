package typeinfo.pets;

import java.util.ArrayList;
import java.util.Random;

public class Pets
{
	public static ArrayList<Pet> arrayList(int n)
	{
		Random rand = new Random(47);
		Pet [] pets = {new Dog(), new Cat(), new Rat(), new Pug(), new Rodent(), 
			new Mutt(), new EgyptianMau(), new Mouse(),  new Hamster(), new Manx(), };
		ArrayList<Pet> al = new ArrayList<Pet>();
		
		for(int i = 0; i < n; i++)
			al.add(pets[rand.nextInt(pets.length)]);
		
		return al;
		
	}
}
