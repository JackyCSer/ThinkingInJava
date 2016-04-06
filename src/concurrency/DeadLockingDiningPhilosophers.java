package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DeadLockingDiningPhilosophers
{
	public static void main(String[] args) throws InterruptedException
	{
		int size = 5;
		int ponderFactor = 0;
		ExecutorService executorService = Executors.newCachedThreadPool();
		Chopstick[] chopsticks = new Chopstick[size];

		for (int i = 0; i < size; i++)
		{
			chopsticks[i] = new Chopstick();
		}

		for (int i = 0; i < size; i++)
		{
			executorService.execute(new Philosopher(chopsticks[i], 
					chopsticks[(i + 1) % size], i, ponderFactor));
		}
		
		TimeUnit.SECONDS.sleep(10);
		
		executorService.shutdownNow();
	}
}
