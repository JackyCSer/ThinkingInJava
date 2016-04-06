package concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo
{

	public static void main(String[] args)
	{
		ExecutorService service = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();

		for (int i = 0; i < 10; i++)
		{
			Future<String> future = service.submit(new TaskWithResult(i));
			results.add(future);
		}

		for (Future<String> future : results)
		{
			try
			{
				System.out.println(future.get());
			} catch (Exception e)
			{
				System.out.println(e);
				return;
			} finally
			{
				service.shutdown();
			}
		}
		System.out.println("-------------End main()--------------");
	}

}

class TaskWithResult implements Callable<String>
{
	private int id;

	public TaskWithResult(int id)
	{
		this.id = id;
	}

	@Override
	public String call() throws Exception
	{
		System.out.println("call(), id = " + id);
		return "Result of TaskWithResult " + "id = " + id;
	}

}