package concurrency;

import java.util.concurrent.TimeUnit;

import initialization.ThisKeywordTest;

// A Runnable containing its driver Thread

public class SelfManaged implements Runnable
{
	private int countDown = 5;
	private Thread thread = new Thread(this);

	public SelfManaged()
	{
		thread.start();
	}

	public String toString()
	{
		return Thread.currentThread().getName() + ", countDown = " + countDown;

	}

	@Override
	public void run()
	{
		System.out.println("run()...");
		try
		{
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (true)
		{
			System.out.println(this);
			countDown--;
			if (countDown == 0)
			{
				return;
			}
			// Thread.yield();
			try
			{
				TimeUnit.MILLISECONDS.sleep(100);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args)
	{
		new SelfManaged();
		new SelfManaged();
		System.out.println("------------End main()----------------");
	}

}
