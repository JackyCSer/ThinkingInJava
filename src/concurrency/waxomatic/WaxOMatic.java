package concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic
{
	public static void main(String[] args) throws Exception
	{
		Car car = new Car();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new WaxOff(car));
		executorService.execute(new WaxOn(car));
		
		TimeUnit.SECONDS.sleep(5);
		executorService.shutdownNow();
	}
}

class Car
{
	private boolean waxOn = false;

	public synchronized void waxed()
	{
		waxOn = true; // Ready to buff
		notifyAll();
	}

	public synchronized void buffed()
	{
		waxOn = false; // Ready for a another coat of wax
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException
	{
		while (!waxOn)
		{
			System.out.println("waitForWaxing...");
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException
	{
		while (waxOn)
		{
			System.out.println("waitForBuffing");
			wait();
		}
	}

}

class WaxOn implements Runnable
{
	private Car car;

	public WaxOn(Car car)
	{
		this.car = car;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				System.out.println("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Ending Wax On task. ");
	}

}

class WaxOff implements Runnable
{

	private Car car;

	public WaxOff(Car car)
	{
		this.car = car;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				car.waitForWaxing();
				System.err.println("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(100);
				car.buffed();
			}
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("Ending Wax Off task. ");
	}

}