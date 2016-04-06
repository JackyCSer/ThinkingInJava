package generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class GenericsDemo2
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		List<Integer> list2 = new ArrayList<Integer>();
		
		list.add("a");
		list.add("b");
		list.add("c");
		
		list2.add(1);
		list2.add(2);
		list2.add(3);
		
		show(list);
		show2(list2);
		show3(list);
	}
	
	public static <T> void show(List<T> list)
	{
		System.out.println("show()");
		for (T t :list)
		{
			System.out.println(t);
		}
	}

	public static <T> void show2(List<T> list)
	{
		System.out.println("show2()");
		for (Iterator<T> i = list.iterator(); i.hasNext();)
		{
			System.out.println(i.next());
		}
	}
	
	public static void show3(List<?> list)
	{
		System.out.println("show3()");
		for (Iterator<?> i = list.iterator(); i.hasNext(); i.next())
		{
			System.out.println(i.getClass().getName());
		}
	}
	
}
