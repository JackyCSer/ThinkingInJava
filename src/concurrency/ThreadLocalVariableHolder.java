package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Automatically giving each thread its own storage:
public class ThreadLocalVariableHolder
{
	// Typically, an anonymous inner class will be used. <from: java doc>
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>()
	{
		private Random random = new Random(47);

		@Override
		protected synchronized Integer initialValue()
		{
			// return random.nextInt(1000);
			return 0;
		}
	};

	public static void increment()
	{
		// System.out.println("value = " + value);
		// System.out.println("value.get()  = " + value.get());
		value.set(value.get() + 1);

	}

	public static int get()
	{
		return value.get();
	}

	public static void main(String[] args) throws InterruptedException
	{
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 50000; i++)
		{
			executor.execute(new Accessor(i));
		}

		TimeUnit.SECONDS.sleep(2); // Run for a while.
		executor.shutdownNow(); // All Accessors will quit.
		System.exit(0);
	}
}

class Accessor implements Runnable
{
	private final int id;

	public Accessor(int id)
	{
		this.id = id;
	}

	@Override
	public void run()
	{
		while (!Thread.currentThread().isInterrupted())
		{

			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();

			System.out.println(Thread.currentThread() + " isInterrupted() = "
					+ Thread.currentThread().isInterrupted());
		}
	}

	public String toString()
	{
		return "id = " + id + ", value = " + ThreadLocalVariableHolder.get();
	}

}