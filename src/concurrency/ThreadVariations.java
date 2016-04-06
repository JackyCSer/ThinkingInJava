package concurrency;

import java.util.concurrent.TimeUnit;

// Creating threads with inner classes.

public class ThreadVariations
{
	public static void main(String[] args)
	{
		new InnerThread1("InnerThread1");
		System.out.println("-------------------------------------");
		new InnerThread2("InnerThread2");
		System.out.println("-------------------------------------");
		new InnerRunnable1("InnerRunnable1");
		System.out.println("-------------------------------------");
		new InnerRunnable2("InnerRunnable2");
		System.out.println("-------------------------------------");
		new ThreadMethod("ThreadMethod").runTask();
		System.out.println("-----------------End main()--------------------");
	}
}

// Using a named inner class:
class InnerThread1
{
	private int countDown = 5;
	private InnerClass innerClass;

	public InnerThread1(String name)
	{
		innerClass = new InnerClass(name);
	}

	// Named inner class:
	class InnerClass extends Thread
	{
		public InnerClass(String name)
		{
			super(name);
			start();
		}

		@Override
		public void run()
		{
			try
			{
				while (true)
				{
					System.out.println(this);
					countDown--;
					if (countDown == 0)
					{
						return;
					}
					sleep(100);
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		@Override
		public String toString()
		{
			return getName() + ", countDown = " + countDown;
		}

	}

}

// Using an anonymous inner class:
class InnerThread2
{
	private int countDown = 5;
	private Thread thread;

	public InnerThread2(String name)
	{
		thread = new Thread(name)
		{
			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						System.out.println(this);
						countDown--;
						if (countDown == 0)
						{
							return;
						}
						sleep(10);
					}
				} catch (Exception e)
				{
					System.out.println(e);
				}
			}

			@Override
			public String toString()
			{
				return getName() + ", countDown = " + countDown;
			}

		}; // End of anonymous inner class

		thread.start();

	}// End of constructor
}

// Using a name Runnable implementation:
class InnerRunnable1 implements Runnable
{
	private int countDown = 5;
	private InnerClass innerClass;

	public InnerRunnable1(String name)
	{
		innerClass = new InnerClass(name);
	}

	private class InnerClass implements Runnable
	{
		Thread thread;

		InnerClass(String name)
		{
			thread = new Thread(this, name);
			thread.start();
		}

		@Override
		public void run()
		{
			while (true)
			{
				System.out.println(this);
				countDown--;
				if (countDown == 0)
				{
					return;
				}

				try
				{
					TimeUnit.MILLISECONDS.sleep(100);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		} // End run()

		@Override
		public String toString()
		{
			return thread.getName() + ", countDown = " + countDown;
		}

	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}
}

// Using an anonymous Runnable implementation:
class InnerRunnable2
{
	private int countDown = 5;
	private Thread thread;

	public InnerRunnable2(String name)
	{
		thread = new Thread(new Runnable()
		{

			@Override
			public void run()
			{
				try
				{
					while (true)
					{
						System.out.println(this);
						countDown--;
						if (countDown == 0)
						{
							return;
						}

						TimeUnit.MILLISECONDS.sleep(100);
					}
				} catch (Exception e)
				{
					System.out.println(e);
				}

			}

			@Override
			public String toString()
			{
				return Thread.currentThread().getName() + ", countDown = "
						+ countDown;
			}

		}, name); // End of anonymous implementation

		thread.start();
	}
}

// A separate method to run some cod as a task:
class ThreadMethod
{
	private int countDown = 5;
	private Thread thread;
	private String name;

	public ThreadMethod(String name)
	{
		this.name = name;
	}

	public void runTask()
	{
		if (thread == null)
		{
			thread = new Thread(name)
			{
				@Override
				public void run()
				{
					while (true)
					{
						System.out.println(this);
						countDown--;
						if (countDown == 0)
						{
							return;
						}

						try
						{
							sleep(100);
						} catch (InterruptedException e)
						{
							e.printStackTrace();
						}
					}// end while
				}

				@Override
				public String toString()
				{
					return getName() + ", countDown = " + countDown;
				}
			}; // End of anonymous inner class
		}

		thread.start();
	}
}
