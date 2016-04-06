package holding;

import java.util.LinkedList;

import typeinfo.pets.*;

public class LinkedListFeatures
{

	public static void main(String[] args)
	{
		LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println("1: " + pets);
		// Identical:
		System.out.println("2: pets.getFirst() " +pets.getFirst());
		System.out.println("3: pets.element() " +pets.element());
		System.out.println("4: pets.peek() " +pets.peek());
		System.out.println("5: pets.remove() " +pets.remove());
		System.out.println("6: pets.removeFirst() " +pets.removeFirst());
		System.out.println("7: " + pets);
		System.out.println("8: pets.poll() " +pets.poll());
		System.out.println("9: " + pets);
		pets.addFirst(new Mouse());
		System.out.println("10: pets.addFirst(new Mouse()) " + pets);
		
		
		
		
		
		
	}

}
