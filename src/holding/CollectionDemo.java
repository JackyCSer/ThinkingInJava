package holding;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionDemo
{
	public static void main(String [] args)
	{
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 10; i++)
		{
			list.add(i + "");
		}
		
		Iterator<String> iterator = list.iterator();
		
		while (iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		

		
		
	}

	
}
