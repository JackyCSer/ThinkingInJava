package concurrency.waxomatic2;

// Using Lock and Condition objects.

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaxOMatic2
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
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	private boolean waxOn = false;

	public void waxed()
	{
		lock.lock();
		try
		{
			waxOn = true; // Ready to buff
			condition.signalAll();
		} finally
		{
			lock.unlock();
		}

	}

	public void buffed()
	{
		lock.lock();
		try
		{
			waxOn = false; // Ready for a another coat of wax
			condition.signalAll();
			
		} finally
		{
			lock.unlock();
		}
	}

	public void waitForWaxing() throws InterruptedException
	{
		lock.lock();
		try
		{
			while (!waxOn)
			{
				System.out.println("waitForWaxing...");
				condition.await();
			}
		} finally
		{
			lock.unlock();
		}
	}

	public void waitForBuffing() throws InterruptedException
	{
		lock.lock();
		try
		{
			while (waxOn)
			{
				System.out.println("waitForBuffing");
				condition.await();
			}
			
		} finally
		{
			lock.unlock();
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
