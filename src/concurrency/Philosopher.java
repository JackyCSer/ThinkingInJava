package concurrency;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable
{
	private Chopstick leftChopstick;
	private Chopstick rightChopstick;
	private final int id;
	private final int ponderFactor;

	private Random random = new Random(47);

	public Philosopher(Chopstick leftChopstick, Chopstick rightChopstick,
			int id, int ponderFactor)
	{
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
		this.id = id;
		this.ponderFactor = ponderFactor;
	}

	private void pause() throws InterruptedException
	{
		if (ponderFactor == 0)
		{
			return;
		} else
		{
			TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
		}

	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				System.out.println(this + " thinging");
				pause();
				// Philosopher becomes hungry
				System.out.println(this + " grabbing rightChopstick");
				rightChopstick.take();

				System.out.println(this + " grabbing leftChopstick");
				leftChopstick.take();
				
				System.out.println(this + "eating...");
				pause();

				rightChopstick.drop();
				leftChopstick.drop();

			}
		} catch (Exception e)
		{
			System.err.println(this + ": " + e);
		}

	}

	public String toString()
	{
		return "Philosoper " + id;
	}

}
