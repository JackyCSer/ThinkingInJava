package containers;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo
{
	public static void main(String[] args)
	{

		Set<Student> set = new TreeSet<Student>(new MyComparator());

		set.add(new Student("a", 22));
		set.add(new Student("bd", 20));
		set.add(new Student("ddd", 19));
		set.add(new Student("ccvb", 18));
		set.add(new Student("c", 19));

		System.out.println(set);
	}
}

class MyComparator implements Comparator<Student>
{

	@Override
	public int compare(Student o1, Student o2)
	{
		return o1.name.length() - o2.name.length();
	}

}

class Student implements Comparable<Student>
{
	String name;
	int age;

	public Student(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return name + " " + age;
	}

	@Override
	public int compareTo(Student o)
	{
		System.out.println(this + " compareTo " + o);

		if (this.age > o.age)
		{
			return 1;
		}
		if (this.age == o.age)
		{
			return this.name.compareTo(o.name);
		}
		return -1;
	}

	@Override
	public boolean equals(Object o)
	{

		System.out.println("eqlals() ---------------");
		return false;

	}

}