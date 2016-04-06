package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Restaurant
{
	Meal meal;
	Chef chef = new Chef(this);
	Customer customer = new Customer(this);
	
	ExecutorService executorService = Executors.newCachedThreadPool();

	public Restaurant()
	{
		executorService.execute(chef);
		executorService.execute(customer);
	}

	public static void main(String[] args)
	{
		new Restaurant();
	}
}

class Meal
{
	private final int orderNumber;

	public Meal(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	@Override
	public String toString()
	{
		return "Meal orderNumber = " + orderNumber;
	}
}

class Customer implements Runnable
{
	private Restaurant restaurant;

	public Customer(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	@Override
	public void run()
	{
		while (!Thread.interrupted())
		{
			synchronized (this)
			{
				try
				{
					while (restaurant.meal == null)
					{
						System.out.println(this
								+ " Wait for the chef to produce a meal. ");
						wait(); // Wait for the chef to produce a meal.
					}

					System.out.println("Customer got meal: " + restaurant.meal);

					synchronized (restaurant.chef)
					{
						restaurant.meal = null;
						restaurant.chef.notifyAll(); // Ready for another
					}

				} catch (InterruptedException e)
				{
					System.err.println(this + " interrupted. ");
				}
			}
		}

	}

}

class Chef implements Runnable
{

	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant restaurant)
	{
		this.restaurant = restaurant;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				synchronized (this)
				{
					while (restaurant.meal != null)
					{
						System.out.println(this
								+ " Wait for the meal to be taken. ");
						wait(); // Wait for the meal to be taken.
					}
				}

				count++;
				if (count == 5)
				{
					System.out.println("Out of food, restaurant closing.");
					restaurant.executorService.shutdownNow();
				}

				System.out.println("Order up! ");
				synchronized (restaurant.customer)
				{
					restaurant.meal = new Meal(count);
					restaurant.customer.notifyAll();
				}

				TimeUnit.MILLISECONDS.sleep(200);
			}
		} catch (Exception e)
		{
			System.err.println(this + " interrupted. ");
		}

	}
}