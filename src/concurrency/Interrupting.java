package concurrency;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Interrupting
{
	private static ExecutorService executor = Executors.newCachedThreadPool();
	
	static void test(Runnable runnable) throws InterruptedException
	{
		Future<?> future = executor.submit(runnable);
		TimeUnit.MILLISECONDS.sleep(100);
		
		System.out.println("Interrupting " + runnable.getClass().getName());
		
		future.cancel(true); // Interrupts if running
		System.err.println("Interrupt sent to " + runnable.getClass().getName());
		//System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0). ");
		System.exit(0);
	}
}

class SleepBlocked implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			TimeUnit.SECONDS.sleep(100);
			
			if (Thread.currentThread().isInterrupted())
			{
				System.err.println("Interrupted from blocked I/O. ");
			}
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		
		
		System.out.println("Exiting SleepBlocked.run()...");
	}

}

class IOBlocked implements Runnable
{
	private InputStream in;

	public IOBlocked(InputStream in)
	{
		this.in = in;
	}

	@Override
	public void run()
	{
		if (Thread.currentThread().isInterrupted())
		{
			System.err.println("Interrupted from blocked I/O. ");
		}
		
		try
		{
			System.out.println("Waiting for read()");
			in.read();
		} catch (Exception e)
		{
			if (Thread.currentThread().isInterrupted())
			{
				System.out.println("Interrupted from blocked I/O. ");
			} else
			{
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked.run()...");
	}

}

class SynchronizedBlocked implements Runnable
{
	// Constructor
	public SynchronizedBlocked()
	{
		Thread thread = new Thread()
		{
			@Override
			public void run()
			{
				f(); // Lock acquired by this thread.
				System.out
						.println("Lock acquired by this thread. Thread name: "
								+ Thread.currentThread());
			}
		};
		thread.start();
	}

	public synchronized void f()
	{
		// Never releases lock
		while (true)
		{
			Thread.yield();
		}
	}

	@Override
	public void run()
	{
		System.out.println("Trying to call f()");
		f();
		if (Thread.currentThread().isInterrupted())
		{
			System.err.println("Interrupted from blocked I/O. ");
		}
		
		
		System.out.println("Exiting SynchronizedBlocked.run()...");
	}

}
