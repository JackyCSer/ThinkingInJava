package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking
{
	private ReentrantLock lock = new ReentrantLock();

	public void untimed()
	{
		boolean captured = lock.tryLock();
		try
		{
			System.out.println("tryLock(): " + captured);
		} finally
		{
			if (captured)
			{
				lock.unlock();
			}
		}

	}

	public void timed()
	{
		boolean captured = false;
		try
		{
			captured = lock.tryLock(2, TimeUnit.SECONDS);

		} catch (InterruptedException e)
		{

			e.printStackTrace();
		}

		try
		{
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);

		} finally
		{
			if (captured)
			{
				lock.unlock();
			}
		}
	}

	public static void main(String[] args)
	{
		final AttemptLocking al = new AttemptLocking();
		al.untimed();
		al.timed();

		// Create a separate task to grab the lock:
		new Thread()
		{
			{
				setDaemon(true);
			}

			@Override
			public void run()
			{
				al.lock.lock();
				System.out.println("Lock acquired. ");
			}
		}.start();
		
		Thread.yield();
		try
		{
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		al.untimed();
		al.timed();
		
		System.out.println("------------End main()------------");
	}

}
