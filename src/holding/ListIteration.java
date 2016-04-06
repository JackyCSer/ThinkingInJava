package holding;

import java.util.*;

import typeinfo.pets.*;

public class ListIteration
{

	public static void main(String[] args)
	{
		List<Pet> pets = Pets.arrayList(8);
		ListIterator<Pet> it = pets.listIterator();
		while(it.hasNext())
			System.out.print(it.next() + ", " + it.nextIndex() + 
					", " + it.previousIndex() + " ");
			
		System.out.println();
			// Backwards:

		while(it.hasPrevious())
			System.out.print(it.previous() + " ");
		System.out.println();
		
		it = pets.listIterator(3);
		while(it.hasNext())
			System.out.print(it.next() + " " );
		
		it.set(new Cat());
		System.out.println();
		
		System.out.println("\n -------------------" );
		while(it.hasPrevious())
			System.out.print(it.previous() + " " );
		System.out.println("\n -------------------" );
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 1; i < 10; i++)
			list.add(i);
		
		ListIterator it2 = list.listIterator();
		while(it2.hasNext())
			System.out.print(it2.next() + " " );
		System.out.println("\n -------------------" );
		
		while(it2.hasPrevious())
			System.out.print(it2.previous() + " " );
	}

}
