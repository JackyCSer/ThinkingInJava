//: innerclasses/LocalInnerClass.java
// Holds a sequence of objects.

package innerclasses;

public class LocalInnerClass
{
	private int count = 0;
	Counter getCounter(final String name)
	{
		// A local inner class:
		class LocalCounter implements Counter
		{
			// Constructor:
			public LocalCounter()
			{
				// Local inner class can have a constructor
				System.out.println("LocalCounter()");
			}
			@Override
			public int next()
			{
				System.out.print(name + " "); 		// Access local final data
				return count++;		// Access outer class's data
			}
			
		}
		
		return new LocalCounter();
	}
	
	// The same thing with an anonymous inner class:
	Counter getCounter2(final String name)
	{
		return new Counter()
		{
			// Anonymous inner class cannot not have a named
			// constructor, only an instance initializer:
			{
				System.out.println("Anonymous Counter()");
			}
			@Override
			public int next()
			{
				System.out.print(name + " "); 		// Access local final data
				return count++; 						// Access outer class data
			}
		};
	}
	
	public static void main(String [] args)
	{
		LocalInnerClass lic = new LocalInnerClass();
		Counter c1 = lic.getCounter("Local inner class");
		Counter c2 = lic.getCounter2("Anonymous inner class");
		for(int i = 0; i < 5; i++)
			System.out.println(c1.next());
		for(int i = 0; i < 5; i++)
			System.out.println(c2.next());
	}
}

interface Counter
{
	int next();
}
