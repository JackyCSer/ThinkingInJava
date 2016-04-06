package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo2
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("bbds");
		list.add("a");
		list.add("da");

		System.out.println(list);
		
		System.out.println("---------------------------");
//		Collections.fill(list, "A");
//		System.out.println(list);
		
		System.out.println("---------------------------");
		Collections.replaceAll(list, "a", "A");
		System.out.println(list);
		System.out.println("---------------------------");
		Collections.reverse(list);
		System.out.println(list);
	}

}
