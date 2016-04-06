package initialization;

public class PassingThis
{
	public static void main(String [] args)
	{
		new Person().eat(new Apple());
	}
}

class Person
{
	public void eat(Apple apple)
	{
		Apple peeled = apple.getPeeled();
		System.out.println("Yummy");
	}
}

class Apple
{
	Apple getPeeled()
	{
		return Peeler.peel(this);
	}
}

class Peeler
{
	static Apple peel(Apple apple)
	{
		System.out.println("Remove peel...");
		return apple;
	}
}
