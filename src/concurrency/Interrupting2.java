package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Interrupting a task blocked with a ReentrantLock

public class Interrupting2
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(new Blocked2());
		thread.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing thread.interrupt(). ");
		thread.interrupt();

	}
}

class BlockedMutex
{
	private Lock lock = new ReentrantLock();

	public BlockedMutex()
	{
		// Acquire it right away, to demonstrate interrupt of a task blocked on
		// a ReentrantLock.
		lock.lock();
	}

	public void f()
	{
		try
		{
			// This will never be available to a second task
			lock.lockInterruptibly(); // Special call
			System.out.println("Lock acquired by f()");

		} catch (Exception e)
		{
			System.err.println("Exception: " + e);
			e.printStackTrace();
		}
	}

}

class Blocked2 implements Runnable
{
	BlockedMutex blocked = new BlockedMutex();

	@Override
	public void run()
	{
		System.out.println("Waiting for f() in BlockedMutex");
		blocked.f();
		System.out.println("Broken out of blocked call");
	}

}