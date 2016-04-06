package concurrency;

// Inheriting directly from the Thread class.

public class SimpleThread extends Thread
{
	private int countDown = 5;
	private static int threadCount = 0;

	public SimpleThread()
	{
		// Store the thread name:
		super("Thread name: " + Integer.toString(++threadCount));
	}

	@Override
	public String toString()
	{
		return getName() + ", countDown = " + countDown;
	}

	@Override
	public void run()
	{
		while (true)
		{
			System.out.println("this = " + this);
			if (--countDown == 0)
			{
				return;
			}
		}
	}
	
	public static void main(String[] args)
	{
		for (int i = 0; i < 5; i++)
		{
			Thread thread = new SimpleThread();
			thread.start();
		}
		System.out.println("------------------------------------");
		
		Thread thread2 = new MyTask();
		thread2.start();
		System.out.println("-----------End main()-----------");
	}
	
	
}

class MyTask extends Thread
{
	@Override
	public void run()
	{
		System.out.println("MyTask, doing something...");
	}
}
