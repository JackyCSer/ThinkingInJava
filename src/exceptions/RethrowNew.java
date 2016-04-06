package exceptions;

// Rethrow a different object from the one that was caught.

public class RethrowNew
{
	public static void f() throws OneException
	{
		System.out.println("Originating the exception in f()");
		throw new OneException("Thrown from f()");
		
	}
	
	public static void main(String[] args)
	{
		try
		{
			try
			{
				f();
			} catch (OneException e)
			{
				System.out.println("Caught in inner try, e.printStackTrace()");
				e.printStackTrace();
				throw new TwoException("From inner try");
			}
		} catch (TwoException e)
		{
			System.out.println("Caught in outer try, e.printStackTrace()");
			e.printStackTrace();
		}
	}
}

class OneException extends Exception
{
	public OneException(String string)
	{
		super(string);
	}
}

class TwoException extends Exception
{
	public TwoException(String string)
	{
		super(string);
	}
}

