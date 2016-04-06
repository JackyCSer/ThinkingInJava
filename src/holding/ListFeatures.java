//: holding/ListFeatures.java

package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.pets.*;

public class ListFeatures
{
	public static void main(String [] args)
	{
		Random rand = new Random(47);
		List<Pet> pets = Pets.arrayList(7);
		System.out.println("1: " + pets);
		Hamster h = new Hamster();
		pets.add(h);
		System.out.println("2: " + pets);
		System.out.println("3: " + pets.contains(h));
		pets.remove(h);
		System.out.println("3.1: " + pets.contains(h));
		Pet p = pets.get(2);
		System.out.println("4: " + p + " indexOf(p): " + pets.indexOf(p));
		Pet cymirc = new Cymric();
		System.out.println("5: " + "indexOf(cymirc): " + pets.indexOf(cymirc));
		System.out.println("6: " + pets.remove(cymirc));
		System.out.println("7: " + pets.remove(p));
		System.out.println("8: " + pets);
		pets.add(3, new Mouse());
		//pets.remove(0);
		System.out.println("9: " + pets);
		List<Pet> sub = pets.subList(1, 4);
		System.out.println("9.1: subList: " + sub);
		System.out.println("10: " + "containsAll(sub): "+pets.containsAll(sub));
		Collections.sort(sub);
		System.out.println("10.1: sorted subList: " + sub);
		// Order is not important in containsAll():
		System.out.println("11: containsAll(sub): " + pets.containsAll(sub));
		Collections.shuffle(sub, rand);		// Mix it up
		System.out.println("11.1: shuffled subList: "+ sub);
		List<Pet> copy = new ArrayList<Pet>(pets);
		sub = Arrays.asList(pets.get(1), pets.get(4));
		System.out.println("12: sub: " + sub);
		System.out.println("13.1: copy: " + copy);
		copy.retainAll(sub);
		System.out.println("13.2: copy: " + copy);
		//sub.remove(1);
		copy.removeAll(sub);
		System.out.println("14: copy: " + copy);
		copy.add(new Mouse());
		System.out.println("15: copy: " + copy);
		copy.addAll(sub);
		
	}
}
