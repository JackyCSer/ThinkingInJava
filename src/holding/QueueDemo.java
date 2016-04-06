//: holding/QueueDemo.java
// Upcasting to a Queue from a LinedList.


package holding;

import java.util.*;
import java.util.Queue;

public class QueueDemo
{
	public static void printQueue(Queue queue)
	{
		while(queue.peek() != null)
		{
			System.out.print(queue.remove() + " ");
		}
		System.out.println();
	}   
	
	public static void main(String [] args)
	{
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for(int i = 0; i  < 10; i++)
		{
			queue.offer(i);
		}
		printQueue(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for(char c : "Brontosaurus".toCharArray())
			qc.add(c);
		printQueue(qc);
	}
}
