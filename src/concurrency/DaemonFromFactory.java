package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
// Using a Thread Factory to create daemons.

public class DaemonFromFactory implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + ", this = " + this);
				
			}
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ExecutorService service = Executors.newCachedThreadPool(new DaemonThreadFactory());
		
		for (int i = 0; i < 5; i++)
		{
			service.execute(new DaemonFromFactory());
			
		}
		
		System.out.println("All Daemons started. ");
		TimeUnit.MILLISECONDS.sleep(300);		// Run for a while.
		
		System.out.println("--------------End main()----------------");
		
	}
}
