package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenChecker implements Runnable
{
	private IntegerGenerator generator;
	private final int id;

	public EvenChecker(IntegerGenerator g, int ident)
	{
		generator = g;
		id = ident;
	}

	@Override
	public void run()
	{
		System.out.println(Thread.currentThread() + " is running...");
		while (!generator.isCanceled())
		{
			int value = generator.next();

			if (value % 2 != 0)
			{
				System.out.println(value + " is NOT even! ");
				generator.cancel();
				System.out.println("-----------------cancel()-----------------");
			} else
			{
				System.out.println(value + " is even. ");
			}
			
			System.out.println("isCanceled() = " + generator.isCanceled());
		}

		System.out.println("-----------End run()-----------");
	}

	public static void test(IntegerGenerator g, int count)
	{
		System.out.println("test()...");
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < count; i++)
		{
			executor.execute(new EvenChecker(g, i));
		}

		executor.shutdown();
	}
}
