package concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable
{

	private AtomicInteger ai = new AtomicInteger();

	public int getValue()
	{
		return ai.get();
	}

	private void evenIncrement()
	{
		ai.addAndGet(2);
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
		System.out.println("----------------main()-------------------");
		// Anonymous inner class
		new Timer().schedule(new TimerTask()
		{
			@Override
			public void run()
			{
				System.err.println("Aborting...");
				System.out.println(Thread.currentThread() + " end");
				System.out.println("Terminates the currently running Java Virtual Machine. ");
				System.exit(0);
			}
		}, 30);

		ExecutorService executor = Executors.newCachedThreadPool();
		AtomicIntegerTest ait = new AtomicIntegerTest();
		executor.execute(ait);

		
		while (true)
		{
			int value = ait.getValue();
			if (value % 2 != 0)
			{
				System.out.println(value + " is NOT even.");
				System.exit(0);
			} else
			{
				System.out.println(value + " is even.");
			}
		}

	}

}
