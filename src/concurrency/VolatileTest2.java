package concurrency;

public class VolatileTest2 extends Thread
{
	public static int n = 0;

	public static synchronized void increase()
	{
		n++;
	}

	public void run()
	{
		for (int i = 0; i < 10; i++)
			try
			{
				increase(); // n = n + 1 改成了 increase();
				sleep(3); // 为了使运行结果更随机，延迟3毫秒

			} catch (Exception e)
			{
			}
	}

	public static void main(String[] args) throws Exception
	{

		Thread threads[] = new Thread[100];
		for (int i = 0; i < threads.length; i++)
			// 建立100个线程
			threads[i] = new VolatileTest2();
		for (int i = 0; i < threads.length; i++)
			// 运行刚才建立的100个线程
			threads[i].start();
		for (int i = 0; i < threads.length; i++)
			// 100个线程都执行完后继续
			threads[i].join();
		System.out.println(" n= " + VolatileTest2.n);
	}
}