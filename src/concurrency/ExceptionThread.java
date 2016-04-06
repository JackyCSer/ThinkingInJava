package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable
{
	@Override
	public void run()
	{
		throw new RuntimeException();
	}

	public static void main(String[] args)
	{

		try
		{
			ExecutorService service = Executors.newCachedThreadPool();
			service.execute(new ExceptionThread());
		} catch (Exception e)
		{
			// This statement will NOT execute.
			System.out.println("Runtime Exception! ");
		}

	}
}
