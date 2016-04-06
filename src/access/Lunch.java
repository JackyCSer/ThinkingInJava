package access;
/*
 * Demonstrate class access specifiers.
 * Make a class effectively private with private constructors:
 * "Singleton" design pattern
 * Can ONLY produce ONE Soup2 object.
 */

// Only one public class allowed per file:
public class Lunch
{
	public static void main(String [] args)
	{
		Lunch L = new Lunch();
		L.testStatic();
		L.testSingleton();
	}
	void testPrivate()
	{
		// Can't do this! Private constructor;
		//Soup1 soup = new Soup1();
	}
	void testStatic()
	{
		//Can produce any number of Soup1 object
		Soup1 soup = Soup1.makeSoup1();
		Soup1 soup2 = Soup1.makeSoup1();
		Soup1 soup3 = Soup1.makeSoup1();
	}
	void testSingleton()
	{
		Soup2.access().f();
		Soup2 sp2 = Soup2.access();
		sp2.f();
	}
}

class Soup1
{
	private Soup1() 
	{
		System.out.println("Soup1()");
	}
	// (1) Allow creation via static method:
	public static Soup1 makeSoup1()
	{
		return new Soup1();
	}
}

class Soup2
{
	private Soup2() 
	{
		System.out.println("Soup2()");
	}
	// (2) create a static object and return a reference
	// upon request. (the "Singleton" design pattern);
	private static Soup2 sp2 = new Soup2();
	public static Soup2 access()
	{
		return sp2;
	}
	public void f() { System.out.println("f()"); }
}
