package containers;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo
{

	public static void main(String[] args)
	{
		Set<Apple2> set = new HashSet<Apple2>();

		set.add(new Apple2("Apple1", 12));
		set.add(new Apple2("Apple2", 13));
		set.add(new Apple2("Apple2", 13));
		set.add(new Apple2("Apple3", 15));
		set.add(new Apple2("Apple4", 17));

		System.out.println(set);
		System.out.println();
		// System.out.println(set.contains(new Apple2("Apple1", 12)));

		System.out.println(set.remove(new Apple2("Apple1", 15)));

		System.out.println(set);
	}

}

class Apple2
{
	String name;
	int age;

	Apple2(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object object)
	{

		Apple2 a = (Apple2) object;

		System.out.println(this + " equals " + a);

		return this.name == a.name && this.age == a.age;
	}

	@Override
	public int hashCode()
	{
		System.out.println(this + " hashCode()");
		return name.hashCode() + age;
	}

	@Override
	public String toString()
	{
		return name + " " + age;
	}
}
