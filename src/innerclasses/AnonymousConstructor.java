package innerclasses;
// Creating a constructor for an anonymous inner class.

public class AnonymousConstructor
{
	public static Base getBase(int i)		// Argument: i NOT been used in the anonymous class,
																// so it not need to be final.
	{
		return new Base(i)
		{
			// Just an expression in return clause, NOT belong to anonymous class
			{ System.out.println("Inside instance initializer");}
			
			public int x = 100;
			
			@Override
			public void f()
			{
				System.out.println("In anonymous f()");
			}
			
		};
	}
	
	public static void main(String [] args)
	{
		Base base = getBase(47);
		base.f();	// Polymorphic method, calling anonymous class's instance's method
		
		// i cannot be resolved or is not a field
		//! System.out.println(base.i);
	}
}

abstract class Base
{
	public Base(int i)
	{
		System.out.println("Base constructor, i = " + i);
	}
	
	public abstract void f();
}

