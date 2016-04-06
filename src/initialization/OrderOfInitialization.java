package initialization;
//Demonstrates initialization order.

public class OrderOfInitialization
{

	public static void main(String [] args)
	{
		System.out.println("main()");
		House h = new House();
		h.f(); 		//Shows that construction is done.
	}
}


class Window
{
	Window(int marker)
	{
		System.out.println("Window(int marker): " + "marker = " + marker);
	}

	public Window()
	{
		
	}
}

class House
{
	Window w1 = new Window(1);		//Before constructor
	
	House()
	{
		//Show that we are in the constructor
		System.out.println("House()");
		w3 = new Window(33);		//reinitialize w3
	}

	Window w2 = new Window(2);		//After constructor

	void f()
	{
		System.out.println("f(): ");
	}
	
	Window w3 = new Window(3); 		//At end of constructor

}
