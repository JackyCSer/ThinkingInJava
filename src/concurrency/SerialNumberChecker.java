package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Operations that may seem safe are NOT, when threads are present.

public class SerialNumberChecker
{
	private static final int size = 10;
	private static CircularSet serials = new CircularSet(1000);
	private static ExecutorService executor = Executors.newCachedThreadPool();

	// Inner class
	static class SerialChecker implements Runnable
	{

		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName());
			while (true)
			{
				int serial = SerialNumberGenerator.nextSerialNumber();
				if (serials.contains(serial))
				{
					System.out.println(Thread.currentThread().getName()
							+ " Duplicate serial = " + serial);
					System.out.println("End run() , "
							+ Thread.currentThread().getName());
					//System.exit(0);
					return;
				} else
				{
					serials.add(serial);
					//System.out.println(Thread.currentThread().getName()
					//		+ " Unique serial = " + serial);
				}
			}
		}
	}

	public static void main(String[] args)
	{
		System.out.println(Thread.currentThread().getName());

		
		for (int i = 0; i < 5; i++)
		{
			executor.execute(new SerialChecker());

			Thread.yield();
		}
		
		
		
		
		System.out.println("----------End main()---------");
	}

}

// Reuses storage so we don't run out of memory.
class CircularSet
{
	private int[] array;
	private int length;
	private int index = 0;

	public CircularSet(int size)
	{
		array = new int[size];
		length = size;

		// Initialize
		for (int i = 0; i < length; i++)
		{
			array[i] = -1;

		}
	}

	public synchronized void add(int i)
	{
		array[index] = i;
		index = (index + 1) % length;
	}

	public synchronized boolean contains(int value)
	{
		for (int i = 0; i < length; i++)
		{
			if (array[i] == value)
			{
				return true;
			}
		}

		return false;
	}

}