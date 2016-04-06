package containers;

import java.util.LinkedList;

public class LinkedListDemo
{
	public static void main(String [] args)
	{
		LinkedList<String> list = new LinkedList<String>();
			
		list.addFirst("Apple 1");
		list.addFirst("Apple 2");	
		list.addFirst("Apple 3");
		list.addFirst("Apple 4");	
		
		System.out.println(list);
	}
}
