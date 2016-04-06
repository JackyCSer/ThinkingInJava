package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// <from: p660>
public class SimplePriorities implements Runnable
{
	private int countDown = 5;
	private volatile double d;
	private int priority;

	public SimplePriorities(int priority)
	{
		this.priority = priority;
	}

	@Override
	public void run()
	{
		Thread.currentThread().setPriority(priority);
		while (true)
		{
			for (int i = 1; i < 100_0000; i++)
			{
				d = d + (Math.PI + Math.E) / (double) i;

				if (i % 10 == 0)
				{
					Thread.yield();
				}
			}

			System.out.println("this = " + this);

			countDown--;
			if (countDown == 0)
			{
				return;
			}
		}
	}

	@Override
	public String toString()
	{
		return Thread.currentThread() + ": " + countDown;
	}

	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();

		for (int i = 0; i < 5; i++)
		{
			service.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		}
		service.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		service.shutdown();

		System.out.println("-------------End main()---------------");
	}
}
