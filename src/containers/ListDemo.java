package containers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ListDemo
{
	public static void main(String[] args)
	{
//		List<String> list = new ArrayList<String>();
//		list.add("Apple1");
//		list.add("Apple2");
//		list.add("Apple3");
//		list.add("Apple4");
//
//		Iterator<String> iterator = list.iterator();
//
//		while (iterator.hasNext())
//		{
//			Object object = iterator.next();
//
//			//list.add("String");
//			//list.remove(2);
//			if (object.equals("Apple3"))
//			{
//				iterator.remove();
//			}
//			
//		}
//
//		
//		System.out.println(list);
		
		String s = "apple";
		
		
//		f(s);
//		
//		System.out.println(s);
		Apple a = new Apple("Apple1");
		System.out.println(a.name);
		g(a);
		System.out.println(a.name);
	}
	Apple apple  = new Apple("1");
	
	static void f(String string)
	{
		string = "hello";
	}
	
	static void g(Apple a)
	{
		a.setName("Dog");;
	}
}

class Apple
{
	Apple(String name)
	{
		this.name = name;
	}
	
	String name;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
