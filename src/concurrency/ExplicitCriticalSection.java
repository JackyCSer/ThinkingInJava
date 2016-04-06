package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExplicitCriticalSection
{
	public static void main(String[] args) throws Exception
	{
		PairManager pairManager1 = new ExplicitPairManagerImpl1();
		PairManager pairManager2 = new ExplicitPairManagerImpl2();

		CriticalSection.testApproaches(pairManager1, pairManager2);

		System.out.println("storage1 = " + pairManager1.getStorage());
		System.out.println("storage2 = " + pairManager2.getStorage());

		System.out.println("------------End main()--------------");
		System.exit(0);
	}
}

// Synchronize the entire method:
class ExplicitPairManagerImpl1 extends PairManager
{
	private Lock lock = new ReentrantLock();

	@Override
	public synchronized void increment()
	{
		// lock.lock();
		try
		{
			pair.incrementX();
			pair.incrementY();
			store(getPair());
		} finally
		{
			// lock.unlock();
		}

	}

}

// Use a critical section:
class ExplicitPairManagerImpl2 extends PairManager
{
	private Lock lock = new ReentrantLock();

	@Override
	public  void increment()
	{
		synchronized (this)
		{
			lock.lock();
			Pair tempPair;
			try
			{
				pair.incrementX();
				pair.incrementY();
				tempPair = getPair();
				store(tempPair);
			} finally
			{
				lock.unlock();
			}
		}
		
	

	}

}