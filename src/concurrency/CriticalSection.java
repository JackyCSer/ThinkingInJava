package concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Synchronizing blocks instead of entire methods.
// Also demonstrates protection of a non-thread-safe class with a thread-safe one.
// <from: p686>

public class CriticalSection
{
	// Test the two different approaches.
	static void testApproaches(PairManager pm1, PairManager pm2)
	{
		ExecutorService executor = Executors.newCachedThreadPool();

		PairManipulator pManipulator1 = new PairManipulator(pm1);
		PairManipulator pManipulator2 = new PairManipulator(pm2);
		PairChecker pairChecker1 = new PairChecker(pm1);
		PairChecker pairChecker2 = new PairChecker(pm2);

		executor.execute(pManipulator1);
		executor.execute(pManipulator2);
		executor.execute(pairChecker1);
		executor.execute(pairChecker2);

		try
		{
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (Exception e)
		{

		}

		System.out.println("pManipulator1: " + pManipulator1
				+ "\npManipulator2: " + pManipulator2);

	}

	public static void main(String[] args)
	{
		System.out.println("------------------Begin main()--------------");
		
		PairManager pairManager1 = new PairManagerImpl1();
		PairManager pairManager2 = new PairManagerImpl2();

		testApproaches(pairManager1, pairManager2);
		
		System.out.println("storage1 = " + pairManager1.getStorage());
		System.out.println("storage2 = " + pairManager2.getStorage());
		
		System.out.println("------------------End main()--------------");
		System.out.println("Terminates the currently running Java Virtual Machine. ");
		System.exit(0);
	}

}

// NOT thread-safe
class Pair
{
	private int x, y;

	public Pair()
	{
		this(0, 0);
	}

	public Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public void incrementX()
	{
		x++;
	}

	public void incrementY()
	{
		y++;

	}

	@Override
	public String toString()
	{
		return "x: " + x + ", y: " + y;
	}

	// Public inner class
	public class PairValuesNotEqualsException extends RuntimeException
	{
		public PairValuesNotEqualsException()
		{
			super("Pair values not equal: " + Pair.this);
		}
	}

	// Arbitrary invariant --both variables must be equal:
	public void checkState()
	{
		if (x != y)
		{
			throw new PairValuesNotEqualsException();
		}
	}

}

// Abstract class
// Protection a Pair inside a thread-safe class:
abstract class PairManager
{
	AtomicInteger checkCounter = new AtomicInteger(0);
	protected Pair pair = new Pair();
	private List<Pair> storage = Collections
			.synchronizedList(new ArrayList<Pair>());

	public List<Pair> getStorage()
	{
		return storage;
	}
	
	public synchronized Pair getPair()
	{
		// Make a copy to keep the original safe:
		return new Pair(pair.getX(), pair.getY());

	}

	// Assume this is a time consuming operation:
	protected void store(Pair pair)
	{
		storage.add(pair);

		try
		{
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}

	public abstract void increment();

}

// Synchronize the entire method:
class PairManagerImpl1 extends PairManager
{
	@Override
	public synchronized void increment()
	{
		pair.incrementX();
		pair.incrementY();
		store(getPair());
	}

}

// Use a critical section
class PairManagerImpl2 extends PairManager
{

	@Override
	public void increment()
	{
		Pair tempPair;

		// Critical Section:
		synchronized (this)
		{
			pair.incrementX();
			pair.incrementY();
			tempPair = getPair();
		}

		store(tempPair);

	}

}

class PairManipulator implements Runnable
{
	private PairManager pairManager;

	public PairManipulator(PairManager pairManager)
	{
		this.pairManager = pairManager;
	}

	@Override
	public void run()
	{
		System.out.println(this.getClass() + ", " + Thread.currentThread());
		while (true)
		{
			pairManager.increment();
		}
	}

	public String toString()
	{
		return "Pair: " + pairManager.getPair() + " checkCounter = "
				+ pairManager.checkCounter.get();

	}

}

class PairChecker implements Runnable
{
	private PairManager pairManager;

	public PairChecker(PairManager pairManager)
	{
		System.out.println(this.getClass() + ", " + Thread.currentThread());
		this.pairManager = pairManager;
	}

	@Override
	public void run()
	{
		System.out.println(this.getClass() + ", " + Thread.currentThread());
		while (true)
		{
			pairManager.checkCounter.incrementAndGet();
			pairManager.getPair().checkState();
		}
	}

}
