package holding;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo
{
	public static void main(String [] args)
	{
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for(int i = 0; i< 10; i ++)
			priorityQueue.offer(rand.nextInt(10));
		
		System.out.println(priorityQueue);
		
		while(priorityQueue.peek() != null)
			System.out.print(priorityQueue.remove() + " ");
		
		PriorityQueue<Integer> queue= 
				new PriorityQueue<Integer>((Collection<? extends Integer>) Collections.reverseOrder());
		queue.addAll(priorityQueue);
		while(priorityQueue.peek() != null)
			System.out.print(priorityQueue.remove() + " ");
	}
}
