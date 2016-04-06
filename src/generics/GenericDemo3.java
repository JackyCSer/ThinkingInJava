package generics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.jar.Attributes.Name;

public class GenericDemo3
{
	public static void main(String[] args)
	{
		
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(new Person("a"));
		list.add(new Person("b"));		
		list.add(new Person("c"));		
		list.add(new Person("d"));		

		ArrayList<Student> list2 = new ArrayList<Student>();
		list2.add(new Student("a"));
		list2.add(new Student("b"));		
		list2.add(new Student("c"));		
		list2.add(new Student("d"));		
		
		show(list2);

		
		
		
	}
	
	static void show(ArrayList<? extends Person> list)
	{
		for (Iterator<? extends Person> i = list.iterator(); i.hasNext();)
		{
			System.out.println(i.next().getName());
		}
	}
}

class Student extends Person implements Comparable<Person>
{
	public Student(String name)
	{
		super(name);
	}

	public Student(String name, int age)
	{
		super(name, age);
	}

	
	@Override
	public int compareTo(Person o)
	{
		return this.getName().compareTo(o.getName());
	}
	
	public String toString()
	{
		return  name + " " + age;
		
	}
	
}

class MyComparator implements Comparator<Person>
{

	@Override
	public int compare(Person o1, Person o2)
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}


class Person
{
	protected String name;
	protected int age;
	
	public Person(String name)
	{
		this.name = name;
		
	}
	
	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
		
	}
	
	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return  name + " " + age;
		
	}
	
	
}