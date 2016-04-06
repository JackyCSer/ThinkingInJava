package utilities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class CollectionsDemo
{

	public static void main(String[] args)
	{
		List<String> list = new ArrayList<String>();
		
		list.add("d");
		list.add("bbds");
		list.add("zss");
		list.add("da");

		System.out.println(list);

		System.out.println("-------------Sort----------------");
		Collections.sort(list, Collections.reverseOrder( new StringLengthComparator()));
		
		System.out.println(list);
		
		
		
		
//		System.out.println("-------------reverse----------------");
//		Collections.sort(list, Collections.reverseOrder());
//		System.out.println(list);
		
		// int i = Collections.binarySearch(list, "da");

		//int i = binarySearch2(list, "da", new StringLengthComparator());

		// System.out.println("a".compareTo("b"));

		//System.out.println(i);

		// System.out.println(Collections.max(list, new
		// StringLengthComparator()));

	}

	public static <T extends Comparable<T>> int binarySearch2(List<T> list,
			T key)
	{
		int max, min, mid;
		max = list.size() - 1;
		min = 0;

		while (max >= min)
		{
			mid = (max + min) >> 1;
			System.out.println("mid = " + mid);
			int temp = key.compareTo(list.get(mid));

			if (temp > 0)
			{
				min = mid + 1;
			} else if (temp < 0)
			{
				max = mid - 1;
			} else
			{
				return mid;
			}
		}

		return min; // insertion point
	}

	public static <T extends Comparable<T>> int binarySearch2(List<T> list,
			T key, Comparator<T> comparator)
	{
		int max, min, mid;
		max = list.size() - 1;
		min = 0;

		while (max >= min)
		{
			mid = (max + min) >> 1;
			System.out.println("mid = " + mid);
			int temp = comparator.compare(key, list.get(mid));

			if (temp > 0)
			{
				min = mid + 1;
			} else if (temp < 0)
			{
				max = mid - 1;
			} else
			{
				return mid;
			}
		}

		return min; // insertion point
	}

	public static void maxDemo(List<String> list)
	{

	}

	public static void sortDemo(List<String> list)
	{

		Collections.sort(list, new StringLengthComparator());

		System.out.println(list);
	}
}

class StringLengthComparator implements Comparator<String>
{

	@Override
	public int compare(String s1, String s2)
	{
		return s1.length() - s2.length();
	}

}

class Student
{
	String name;
	int age;

	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
}