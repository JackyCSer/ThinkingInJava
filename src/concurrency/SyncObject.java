package concurrency;

public class SyncObject
{
	public static void main(String[] args)
	{
		final DualSynchronization ds = new DualSynchronization();
		Thread thread = new Thread()
		{
			@Override
			public void run()
			{
				ds.f();
			}
		};
		
		thread.start();
		//System.out.println(thread.getClass());
		ds.g();
		System.out.println("-----------End main()--------------");
	}

}

class DualSynchronization
{
	private Object syncObject = new Object();

	public synchronized void f()
	{
		for (int i = 0; i < 5; i++)
		{
			System.out.println("f()");
			Thread.yield();
		}
	}

	public void g()
	{
		synchronized (syncObject)
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.println("g()");
				Thread.yield();
			}
		}
	}

}