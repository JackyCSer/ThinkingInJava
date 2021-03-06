package concurrency;

// Understanding join()
// <from: p670>

public class Joining
{
	public static void main(String[] args)
	{
		Sleeper sleepy = new Sleeper("Sleepy", 1500);
		Sleeper grumpy = new Sleeper("Grumpy", 1500);

		Joiner dopeyJoiner = new Joiner("Dopey", sleepy);
		Joiner doc = new Joiner("Doc", grumpy);

		grumpy.interrupt();
	}
}

class Sleeper extends Thread
{
	private int duration;

	public Sleeper(String name, int sleepTime)
	{
		super(name);
		duration = sleepTime;
		start();
	}

	@Override
	public void run()
	{
		try
		{
			sleep(duration);
		} catch (InterruptedException e)
		{
			System.out.println(getName() + " was interrupted. "
					+ "isInterrupted() = " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened. ");
	}
}

class Joiner extends Thread
{
	private Sleeper sleeper;

	public Joiner(String name, Sleeper sleeper)
	{
		super(name);
		this.sleeper = sleeper;
		start();
	}

	@Override
	public void run()
	{
		try
		{
			sleeper.join();
		} catch (Exception e)
		{
			System.out.println(e);
		}

		System.out.println(getName() + " join() completed. ");
	}
}
