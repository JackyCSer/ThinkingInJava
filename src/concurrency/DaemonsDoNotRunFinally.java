package concurrency;

import java.util.concurrent.TimeUnit;

public class DaemonsDoNotRunFinally
{
	public static void main(String[] args)
	{
		Thread thread = new Thread(new ADaemon());
		//thread.setDaemon(true);
		thread.start();
		System.out.println("--------------End main()-------------");
	}
}

class ADaemon implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			System.out.println("Starting a daemon...");
			TimeUnit.SECONDS.sleep(1);

		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			System.out.println("finally...");
		}
	}

}