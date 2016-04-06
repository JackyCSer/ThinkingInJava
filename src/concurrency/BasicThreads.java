package concurrency;

public class BasicThreads
{
	public static void main(String [] args)
	{
		Thread thread = new Thread(new LiftOff());
		thread.start();
		System.out.println("Wating for lift off...");
		System.out.println("id = " +  thread.getId());
		System.out.println("name = " + thread.getName());
		System.out.println("doing other things...");
		System.out.println("-----------End main()-------------");
	}
}
