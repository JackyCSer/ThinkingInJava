package exceptions;

public class ExceptionSilence
{
	@SuppressWarnings("finally")
	public static void main(String[] args)
	{
		try
		{
			throw new RuntimeException();
		} finally{
		
		}
	}
}
