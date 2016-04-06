package exceptions;

public class MultipleReturns
{
	static void f(int i)
	{
		System.out.println("Initialization that requires cleanup. ");
		try
		{
			System.out.println("Point 1");
			if (i == 1)
			{
				return;
			}
			
			System.out.println("Point 2");
			if (i == 2)
			{
				return;
			}
		} finally
		{
			System.out.println("Finally clause, performing cleanup. ");
			
		}
	}

	public static void main(String[] args)
	{
		f(1);
		f(2);
	}
}
