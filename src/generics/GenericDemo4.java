package generics;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo4
{

	public static void main(String[] args)
	{
		TreeSet<Student> set = new TreeSet<Student>(new MyComparator3());

		set.add(new Student("a", 19));
		set.add(new Student("b", 13));
		set.add(new Student("c", 14));
		set.add(new Student("d", 15));

		System.out.println(set);
		
		TreeSet<Worker> set2 = new TreeSet<Worker>(new MyComparator3());

		set2.add(new Worker("a", 19));
		set2.add(new Worker("b", 13));
		set2.add(new Worker("c", 14));
		set2.add(new Worker("d", 15));
		
		System.out.println(set2);

	}

}

class MyComparator2 implements Comparator<Student>
{
	@Override
	public int compare(Student s1, Student s2)
	{
		return s1.getAge() - s2.getAge();
	}
}

class MyComparator3 implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2)
	{
		return p2.getAge() - p1.getAge();
	}
}

class Worker extends Person
{

	public Worker(String name, int age)
	{
		super(name, age);
	}

}