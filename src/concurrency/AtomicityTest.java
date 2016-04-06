package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class AtomicityTest implements Runnable
{
	private int i = 0;

	public synchronized int getValue()
	{
		return i;
	}

	private synchronized void evenIncrement()
	{
		i++;
		i++;
	}

	@Override
	public void run()
	{
		while (true)
		{
			evenIncrement();
		}
	}

	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		executor.execute(at);
		while (true)
		{
			int value = at.getValue();
			if (value % 2 != 0)
			{
				System.out.println(value);
				System.exit(0);
			} else
			{
				System.out.println(value + " is even.");
			}
		}
	}
}
