package holding;

import java.util.*;

public class SetOperation
{
	public static void main(String [] args)
	{
		Set<String> set1 = new HashSet<String>();
		Collections.addAll(set1, "A B C D E F G H I J K L".split(" "));
		set1.add("M");
		System.out.println(set1);
		System.out.println("set1.contains() " + set1.contains("H") );
		
	}
}
