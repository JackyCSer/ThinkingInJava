package concurrency;

public class LiftOff implements Runnable
{
	protected int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff()
	{

	}

	public LiftOff(int countDown)
	{
		this.countDown = countDown;
	}

	public String status()
	{
		return "id = " + id + " (" + (countDown > 0 ? countDown : "Lift off!")
				+ ")";
	}

	@Override
	public void run()
	{
		System.out.println("Thread: " + Thread.currentThread() + " Calling run()...");
		while (countDown > 0)
		{
			countDown--;
			System.out.println(status());
			Thread.yield();

		}

	}

}
