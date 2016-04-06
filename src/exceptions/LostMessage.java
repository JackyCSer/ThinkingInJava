package exceptions;

public class LostMessage
{
	static void f() throws VeryImportantException
	{
		throw new VeryImportantException();
	}
	
	static void dispose() throws HoHumException
	{
		throw new HoHumException();
	}
	
	public static void main(String[] args)
	{
		try
		{
			try
			{
				f();
			} finally
			{
				dispose();
			}
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}
}

class VeryImportantException extends Exception
{
	public String toString()
	{
		return "A very important exception. ";
	}
	
	
}

class HoHumException extends Exception
{
	public String toString()
	{
		return "A trivial exception. ";
		
	}
}

