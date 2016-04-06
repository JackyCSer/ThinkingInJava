package concurrency;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MultiProcessTest
{
	public static void main(String[] args) throws InterruptedException
	{
		Runtime run = Runtime.getRuntime();
		try
		{
			Process p = run.exec("java test1");
			System.out.println(p);
			TimeUnit.SECONDS.sleep(10);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}