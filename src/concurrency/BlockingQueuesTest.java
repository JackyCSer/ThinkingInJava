package concurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;

public class BlockingQueuesTest
{

	static void getKey()
	{
		try
		{
			// Compensate for Windows/Linux difference in the length of the
			// result produced by the Enter key:
			new BufferedReader(new InputStreamReader(System.in)).readLine();

		} catch (Exception e)
		{
			System.err.println(e);
		}
	}
	
	static void getKey(String message)
	{
		System.out.println("Message: " + message);
		getKey();
	}
	
	static void test(String message, BlockingQueue<LiftOff> queue)
	{
		System.out.println(message);
		LiftOffRunner runner = new LiftOffRunner(queue);
		
		Thread thread = new Thread(runner);
		thread.start();
		
		for (int i = 0; i < 5; i++)
		{
			runner.add(new LiftOff(5));
		}
		
		getKey("Press 'Enter' (" + message + ")");
		thread.interrupt();
		System.out.println("Finished " + message + " test. ");
		
	}

	public static void main(String[] args)
	{
		test("LinkedBlockingQueue", new LinkedBlockingDeque<LiftOff>()); // Unlimited size
		test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));   // Fixed size
		test("SynchronousQueue", new SynchronousQueue<LiftOff>());
	}
}

class LiftOffRunner implements Runnable
{
	private BlockingQueue<LiftOff> rockets;

	public LiftOffRunner(BlockingQueue<LiftOff> queue)
	{
		rockets = queue;
	}

	public void add(LiftOff liftOff)
	{
		try
		{
			rockets.put(liftOff);
		} catch (Exception e)
		{
			System.out.println("Interrupted during put()");
		}
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				LiftOff rocket = rockets.take();
				rocket.run(); // Use this thread to run.
			}
		} catch (Exception e)
		{
			System.err.println("Waking from take(). ");
		}

		System.out.println("Exiting LiftOffRunner. ");
	}

}