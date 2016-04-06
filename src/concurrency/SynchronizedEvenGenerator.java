package concurrency;

import java.util.concurrent.TimeUnit;

public class SynchronizedEvenGenerator extends IntegerGenerator
{
	private int currentEvenValue = 0;
	@Override
	public synchronized int next()
	{
		++currentEvenValue;
		
		try
		{
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		++currentEvenValue;
		
		return currentEvenValue;
	}
	
	
	public static void main(String[] args)
	{
		EvenChecker.test(new SynchronizedEvenGenerator(), 3);
	}
}
