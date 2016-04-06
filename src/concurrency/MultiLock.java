package concurrency;

public class MultiLock
{
	public synchronized void f1(int count)
	{
		System.out.println("Entering f1()");
		System.err.println(Thread.currentThread());
		if (count > 0)
		{
			count--;
			System.out.println("f1() calling f2() with count = " + count);
			f2(count);
		}
		System.out.println("Exiting f1()");
	}

	public synchronized void f2(int count)
	{
		System.out.println("Entering f2()");
		System.err.println(Thread.currentThread());
		if (count > 0)
		{
			count--;
			System.out.println("f2() calling f1() with count = " + count);
			f1(count);
		}
		System.out.println("Exiting f2()");
	}

	public static void main(String[] args)
	{
		System.err.println(Thread.currentThread());
		final MultiLock multiLock = new MultiLock();
		new Thread()
		{
			@Override
			public void run()
			{
				System.err.println(Thread.currentThread());
				multiLock.f1(10);
			}
		}.start();
	}
}
