package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// <from: p659>
public class SleepingTask extends LiftOff
{
	@Override
	public void run()
	{
		try
		{
			while (countDown-- > 0)
			{
				System.out.println(status());
				TimeUnit.SECONDS.sleep(1);
			}
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}
	
	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
		{
			service.execute(new SleepingTask());
		}
		service.shutdown();
		System.out.println("-------------End main()-----------------");
	}
}
