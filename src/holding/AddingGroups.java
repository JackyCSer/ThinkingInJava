//: holding/AddingGroups.java
// Adding groups of elements to Collection objects.

package holding;


import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AddingGroups
{
	public static void main(String [] args)
	{
		Collection<Integer> collection = 
				new LinkedList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Integer [] moreInts = { 6, 7, 8, 9, 10};
		collection.addAll(Arrays.asList(moreInts));
		// Runs significantly faster, but you can't construct a Collection this way:
		Collections.addAll(collection, moreInts);
		System.out.println(collection);
		
		// Produces a list "backed by" an array:
		// Returns: a list VIEW of the specified array
		List<Integer> list = Arrays.asList(16, 17, 18, 19, 20);
		list.set(1, 99);
		//! list.add(21);	// Runtime error because the underlying array cannot be resized.
		System.out.println(list);
	}
}
