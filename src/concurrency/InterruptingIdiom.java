package concurrency;

import java.util.concurrent.TimeUnit;

// General idiom for interrupting a task.

public class InterruptingIdiom
{
	public static void main(String[] args) throws InterruptedException
	{
		Thread thread = new Thread(new Blocked3());
		thread.start();
		TimeUnit.MILLISECONDS.sleep(1000);
		thread.interrupt();
	}
}

class NeedsCleanUp
{
	private final int id;

	public NeedsCleanUp(int id)
	{
		this.id = id;
		System.out.println("NeedsCleanUp id = " + id);
	}

	public void cleanUp()
	{
		System.out.println("Cleaning up " + id);
	}

}

class Blocked3 implements Runnable
{
	private volatile double d = 0.0;

	@Override
	public void run()
	{
		try
		{
			boolean flag = true;
			while (flag)
			{
				flag = !Thread.interrupted();
				// point1
				NeedsCleanUp n1 = new NeedsCleanUp(1);
				// Start try-finally immediately after definition
				// of n1, to guarantee proper clean up of n1;
				try
				{
					System.out.println("Sleeping...");
					TimeUnit.SECONDS.sleep(1);

					// point2
					NeedsCleanUp n2 = new NeedsCleanUp(2);
					// Guarantee proper clean up of n2:
					try
					{
						System.out.println("Calculating...");
						// A time-consuming, non-blocking operation:
						for (int i = 1; i < 2_500_000; i++)
						{
							d = d + (Math.PI + Math.E) / d;
						}
						System.out
								.println("Finished time-consuming operation. ");

					} finally
					{
						n2.cleanUp();
					}
				} finally
				{
					n1.cleanUp();
				}
			}
			System.out
					.println("Exiting via while() test. flag = "
							+ flag);
		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}