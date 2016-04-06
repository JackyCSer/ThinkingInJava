package containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest
{
	public static void main(String[] args)
	{
		HashMap<Teacher, String> map = new HashMap<Teacher, String>();
		
		map.put(new Teacher("a", 17), "SH");
		map.put(new Teacher("b", 19), "HZ");
		map.put(new Teacher("a", 18), "BJ");
		
		System.out.println(map);
		
		Set<Teacher> keySet = map.keySet();
		Iterator<Teacher> iterator = keySet.iterator();
		
		while (iterator.hasNext())
		{
			Teacher teacher = iterator.next();
			System.out.println(teacher + " "+ map.get(teacher));
		}
		System.out.println("------------------------------------");
		Set<Map.Entry<Teacher, String>> set = map.entrySet();
		for (Map.Entry<Teacher, String> entry: set)
		{
			System.out.println(entry);
		}
		
		
	}
}


class Teacher implements Comparable<Teacher>
{
	String name;
	int age;

	
	public Teacher(String name, int age)
	{
		this.name = name;
		this.age = age;
		
	}
	
	@Override
	public int hashCode()
	{
		return name.hashCode() + age * 31;
	}
	
	@Override
	public boolean equals(Object object)
	{
		
		if (!(object instanceof Teacher))
		{
			throw new ClassCastException();
		}
		Teacher teacher = (Teacher) object;
		
		System.out.println("equals: " + this + teacher);
		return this.name.equals(teacher.name) && this.age == teacher.age;
	}

	@Override
	public int compareTo(Teacher o)
	{
		int i =  this.name.compareTo(o.name);
		if ( i == 0)
			return this.age - o.age;
		
		return i;
	}
	
	@Override
	public String toString()
	{
		return this.name + " " + this.age;
	}
}