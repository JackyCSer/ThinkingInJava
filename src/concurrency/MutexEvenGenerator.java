package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Preventing thread collisions with mutexes.

public class MutexEvenGenerator extends IntegerGenerator
{
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();

	@Override
	public int next()
	{
		lock.lock();
		System.out.println("lock------------------");
		try
		{
			++currentEvenValue;
			Thread.yield();
			++currentEvenValue;

			return currentEvenValue;
		} finally
		{
			lock.unlock();
			System.out.println("unlock------------------");
		}

	}

	public static void main(String[] args)
	{
		EvenChecker.test(new MutexEvenGenerator(), 3);
	}
}
