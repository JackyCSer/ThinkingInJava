package concurrency;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PipedIO
{
	public static void main(String[] args) throws IOException, InterruptedException
	{
		Sender sender = new Sender();
		Receiver receiver = new Receiver(sender);
	
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(sender);
		executorService.execute(receiver);
		
		TimeUnit.SECONDS.sleep(5);
		executorService.shutdownNow();
		
	
	}
}

class Sender implements Runnable
{
	private Random random = new Random(47);
	private PipedWriter out = new PipedWriter();

	public PipedWriter getPipedWriter()
	{
		return out;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				for (char c = 'A'; c <= 'z'; c++)
				{
					out.write(c);
					TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
				}
			}
		} catch (Exception e)
		{
			System.err.println(e);
		}
	}
}

class Receiver implements Runnable
{
	private PipedReader in;

	public Receiver(Sender sender) throws IOException
	{
		in = new PipedReader(sender.getPipedWriter());
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				// Blocks until characters are there:
				System.out.println("Read: " + (char) in.read()  + ", ");
			}
		} catch (Exception e)
		{
			System.err.println(e);
		}

	}

}