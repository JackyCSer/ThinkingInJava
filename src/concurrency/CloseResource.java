package concurrency;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CloseResource
{
	public static void main(String[] args) throws IOException,
			InterruptedException
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		InputStream socketInput = new Socket("localhost", 8080)
				.getInputStream();

		executor.execute(new IOBlocked(socketInput));
		executor.execute(new IOBlocked(System.in));

		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Shutting down all threads. ");
		executor.shutdownNow();
		TimeUnit.SECONDS.sleep(1);
		System.err.println("Closing " + socketInput.getClass().getName());
		socketInput.close(); // Releases blocked thread.

		TimeUnit.SECONDS.sleep(1);
		System.err.println("Closing " + System.in.getClass().getName());
		System.in.close(); // Releases blocked thread.

	}
}
