//: innerclasses/Callbacks.java
// Using inner classes for callbacks.

package innerclasses;

public class Callbacks
{
	public static void main(String[] args)
	{
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		System.out.println("1-----------------------");
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		System.out.println("go----------------------");
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();

	}

}

interface Incrementable
{
	void increment();
}

// Very simple to just implement the interface:
class Callee1 implements Incrementable
{
	private int i = 0;

	@Override
	public void increment()
	{
		i++;
		System.out.println("Callee1: i = " + i);
	}

}

class MyIncrement
{
	public void increment()
	{
		System.out.println("MyIncrement: Other operation");
	}

	static void f(MyIncrement mi)
	{
		mi.increment();
	}
}

// If you class must implement increment() in some other way,
// you must use an inner class:
class Callee2 extends MyIncrement
{
	private int i = 0;

	@Override
	public void increment()
	{
		super.increment();
		i++;
		System.out.println("Callee2: i = " + i);
	}

	private class Closure implements Incrementable
	{

		@Override
		public void increment()
		{
			// Specify outer-class method, otherwise you'd get an infinite
			// recursion:
			Callee2.this.increment();

		}
	}

	Incrementable getCallbackReference()
	{
		return new Closure(); // Upcasting to Incrementable
	}
}

class Caller
{
	private Incrementable callbackReference;

	Caller(Incrementable cbh)
	{
		callbackReference = cbh;
	}

	void go()
	{
		callbackReference.increment();
	}

}
