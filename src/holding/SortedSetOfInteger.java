package holding;

import java.util.*;

public class SortedSetOfInteger
{

	public static void main(String[] args)
	{
		Random rand = new Random(47);
		
		SortedSet<Integer> sset = new TreeSet<Integer>();
		for(int i = 0; i < 1000; i++)
			sset.add(rand.nextInt(40));
		System.out.println("TreeSet: " + sset);
		
		Set<Integer> hset = new HashSet<Integer>(sset);
		System.out.println("HashSet: " + hset);
		
	}

}
