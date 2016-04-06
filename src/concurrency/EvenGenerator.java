package concurrency;

import java.util.concurrent.TimeUnit;

public class EvenGenerator extends IntegerGenerator
{
	private int currentEvenValue = 0;
	
	@Override
	public int next()
	{
		++currentEvenValue;		// Danger point here! 
		Thread.yield();
		Thread.yield();
		++currentEvenValue;

		return currentEvenValue;
	}
	
	public static void main(String[] args)
	{
		EvenChecker.test(new EvenGenerator(), 3);
		
		System.out.println("------------End main()-----------");
	}

}
