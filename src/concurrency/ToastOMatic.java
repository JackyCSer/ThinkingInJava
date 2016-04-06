package concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class ToastOMatic
{
	public static void main(String[] args) throws InterruptedException
	{
		ToastQueue dryQueue = new ToastQueue();
		ToastQueue butteredQueue = new ToastQueue();
		ToastQueue finishedQueue = new ToastQueue();

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Toaster(dryQueue));
		executorService.execute(new Butterer(dryQueue, butteredQueue));
		executorService.execute(new Jammer(butteredQueue, finishedQueue));
		executorService.execute(new Eater(finishedQueue));

		TimeUnit.MILLISECONDS.sleep(700);
		executorService.shutdownNow();
	}

}

class Toast
{
	public enum Status
	{
		DRY, BUTTERED, JAMMED
	}

	private Status status = Status.DRY;

	private final int id;

	public Toast(int id)
	{
		this.id = id;
	}

	public void butter()
	{
		status = Status.BUTTERED;
	}

	public void jam()
	{
		status = Status.JAMMED;
	}

	public Status getStatus()
	{
		return status;
	}

	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return "Toast id = " + id + ",  " + "Status = " + status;
	}

}

class ToastQueue extends LinkedBlockingDeque<Toast>
{

}

class Toaster implements Runnable
{
	private ToastQueue toastQueue;
	private int count = 0;
	private Random random = new Random(47);

	public Toaster(ToastQueue toastQueue)
	{
		this.toastQueue = toastQueue;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				TimeUnit.MILLISECONDS.sleep(100 + random.nextInt(500));

				System.out.println("Making Toast...");
				Toast toast = new Toast(count++);
				System.out.println("Toast: " + toast);
				toastQueue.put(toast);

			}
		} catch (Exception e)
		{
			System.err.println("Toaster interrupted. ");
		}
		System.out.println("Toaster off. ");
	}

}

// Apply butter to toast:
class Butterer implements Runnable
{
	private ToastQueue dryQueue, butteredQueue;

	public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue)
	{
		this.dryQueue = dryQueue;
		this.butteredQueue = butteredQueue;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece of toast is available:
				Toast toast = dryQueue.take();
				toast.butter();
				System.out.println("Toast: " + toast);
				butteredQueue.put(toast);
			}
		} catch (Exception e)
		{
			System.err.println("Butterer interrupted. ");
		}

		System.out.println("Butterer off. ");
	}

}

// Apply jam to buttered toast:
class Jammer implements Runnable
{
	private ToastQueue butteredQueue, finishedQueue;

	public Jammer(ToastQueue butteredQueue, ToastQueue finishedQueue)
	{
		this.butteredQueue = butteredQueue;
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece is available:
				Toast toast = butteredQueue.take();
				toast.jam();
				finishedQueue.put(toast);
			}
		} catch (Exception e)
		{
			System.err.println("Jammer interrupted. ");
		}

		System.out.println("Jammer off. ");
	}

}

// Consume the toast:
class Eater implements Runnable
{

	private ToastQueue finishedQueue;
	private int counter = 0;

	public Eater(ToastQueue finishedQueue)
	{
		this.finishedQueue = finishedQueue;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece of toast is available:
				Toast toast = finishedQueue.take();
				
				// Verify that the toast is coming in order,
				// and that all pieces are getting jammed.
				if (toast.getId() != counter++
						|| toast.getStatus() != Toast.Status.JAMMED)
				{
					System.out.println("Error: " + toast);
					System.exit(0);
				} else
				{
					System.out.println("Chomp " + toast);
				}

			}
		} catch (Exception e)
		{
			System.err.println("Eater interrupted. ");
		}
		System.out.println("Eater off. ");
	}

}
