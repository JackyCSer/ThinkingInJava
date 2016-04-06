package containers;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListTest
{

	public static void main(String[] args)
	{
		ArrayList<Person> list = new ArrayList<Person>();

		list.add(new Person("a", 17));
		list.add(new Person("a", 17));
		list.add(new Person("b", 18));
		list.add(new Person("c", 19));
		list.add(new Person("d", 24));

		System.out.println(list);

		ArrayList<Person> list2 = new ArrayList<Person>();

		Iterator<Person> iterator = list.iterator();
		
		for (Person p : list)
		{
			if (!list2.contains(p))
			{
				list2.add(p);
			}
		}

		System.out.println(list2);

	}
}

class Person
{
	Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	String name;
	int age;

	@Override
	public String toString()
	{
		return name + " " + age;
	}

	@Override
	public boolean equals(Object object)
	{
		if (!(object instanceof Person))
		{
			return false;
		}
		Person person = (Person) object;
		return this.name.equals(person.name) && this.age == person.age;
	}

	@Override
	public int hashCode()
	{
		return name.hashCode() + age;
	}
}