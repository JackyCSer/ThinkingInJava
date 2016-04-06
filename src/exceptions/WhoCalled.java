package exceptions;

public class WhoCalled
{
	static void f()
	{
		// Generate an exception to fill in the stack trace.
		try
		{
			throw new Exception("My Exception");
		} catch (Exception e)
		{
			for (StackTraceElement element : e.getStackTrace())
			{
				System.out.println(element);
			}
		}
	}
	
	static void g()
	{
		f();
	}
	
	static void h()
	{
		g();
	}
	
	
	public static void main(String[] args)
	{
		
		f();
		System.out.println("-------------------------------");
		g();
		System.out.println("-------------------------------");
		h();
	}

}
