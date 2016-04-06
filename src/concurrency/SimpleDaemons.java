package concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable
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
			System.out.println("sleep() interrupted");
		}

	}

	public static void main(String[] args) throws Exception
	{
		for (int i = 0; i < 5; i++)
		{
			Thread daemonThread = new Thread(new SimpleDaemons());
			daemonThread.setDaemon(true);		// Must call before start();
			daemonThread.start();
		}
		
		System.out.println("All daemons started.");
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("----------------End main()-----------------");
		
	}
	
	
}
