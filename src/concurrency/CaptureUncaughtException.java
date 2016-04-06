package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class CaptureUncaughtException
{
	public static void main(String[] args)
	{
		ExecutorService service = Executors
				.newCachedThreadPool(new HandlerThreadFactory());

		service.execute(new ExceptionThread2());
	}
}

class ExceptionThread2 implements Runnable
{

	@Override
	public void run()
	{
		System.out.println("----------run()------------");
		Thread.yield();
		Thread thread = Thread.currentThread();
		System.out.println("run by: " + thread);
		System.out.println("Exception Handler: "
				+ thread.getUncaughtExceptionHandler());

		throw new RuntimeException();

	}

}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler
{

	@Override
	public void uncaughtException(Thread t, Throwable e)
	{
		System.out.println("Caught: " + e);
		System.out.println("Exception handling...");
	}

}

class HandlerThreadFactory implements ThreadFactory
{

	@Override
	public Thread newThread(Runnable r)
	{
		System.out.println(this + " creating a new Thread");
		Thread thread = new Thread(r);
		System.out.println("Thread: " + thread + " was created. ");
		thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		
		System.out.println("Exception Handler: "
				+ thread.getUncaughtExceptionHandler());
		return thread;

	}

}