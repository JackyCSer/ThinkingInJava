package concurrency;

import java.util.concurrent.TimeUnit;

// Daemon threads spawn other daemon threads.
public class Daemons
{
	public static void main(String[] args) throws Exception
	{
		Thread thread = new Thread(new Daemon());
		thread.setDaemon(true);
		thread.start();
		System.out.println("thread.isDaemon() = " + thread.isDaemon());
		
		TimeUnit.SECONDS.sleep(1);
		
		System.out.println("--------------End main()---------------");
	}
}

class Daemon implements Runnable
{
	private Thread[] threads = new Thread[10];
	
	@Override
	public void run()
	{
		for (int i = 0; i < threads.length; i++)
		{
			threads[i] = new Thread(new DaemonSpawn());
			threads[i].start();
			System.out.println("DaemonSpawn " + i + " is started. ");
		}
		
		for (int i = 0; i < threads.length; i++)
		{
			System.out.println("theads[" + i + "]" + "isDaemon()=" + threads[i].isDaemon());
		}
		
		while (true)
		{
			Thread.yield();
		}
	}
	
}

class DaemonSpawn implements Runnable
{

	@Override
	public void run()
	{
		while (true)
		{
			Thread.yield();
		}
		
	}
	
}
