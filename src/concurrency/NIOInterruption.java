package concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// Interrupting a blocked NIO channel

public class NIOInterruption
{
	public static void main(String[] args) throws IOException,
			InterruptedException
	{
		ExecutorService executor = Executors.newCachedThreadPool();
		// ServerSocket server = new ServerSocket(8080);

		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);

		Future<?> future = executor.submit(new NIOBlocked(sc1));
		executor.execute(new NIOBlocked(sc2));
		executor.shutdown();

		TimeUnit.SECONDS.sleep(1);

		// Produce an interrupt via cancel:
		future.cancel(true);
		
		TimeUnit.SECONDS.sleep(1);
		// Releases the block by closing the channel:
		sc2.close();
	}
}

class NIOBlocked implements Runnable
{
	private final SocketChannel sc;

	public NIOBlocked(SocketChannel sc)
	{
		this.sc = sc;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Waiting for read() in " + this);
			sc.read(ByteBuffer.allocate(1));
		} catch (Exception e)
		{
			System.err.println("Exception: " + e);
		}

		System.out.println("Exiting NIOBlocked.run() " + this);
	}

}
