package exceptions;

// Demonstrating fillInStackTrace()


public class Rethrowing
{
	public static void f() throws Exception
	{
		System.out.println("Originating the exception in f()");
		throw new Exception("Thrown from f()");
	}
	
	public static void g() throws Exception
	{
		try
		{
			f();
		} catch (Exception e)
		{
			System.out.println("Inside g(), e.printStackTrace()");
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void h() throws Exception
	{
		try
		{
			f();
		} catch (Exception e)
		{
			System.out.println("Inside h(), e.printStackTrace()");
			e.printStackTrace();
			throw (Exception) e.fillInStackTrace();
		}
	}

	public static void main(String[] args)
	{
		try
		{
			g();
		} catch (Exception e)
		{
			System.out.println("main() 1, e.printStackTrace()");
			e.printStackTrace();
		}
		
		System.out.println();
		try
		{
			h();
		} catch (Exception e)
		{
			System.out.println("main() 2, e.printStackTrace()");
			e.printStackTrace();
		}
	}
	
}
