package initialization;
//Calling constructors with "this"
public class Flower
{
	int petalCount = 0;
	String s = "initial value";
	
	Flower()
	{
		this("hi", 47);	
		System.out.println("Constructor: Flower()");
	}
	
	Flower(int petals)
	{
		petalCount = petals;
		System.out.println("Constructor: Flower(int petals), petals=" + petals);
	}
	
	Flower(String ss)
	{
		s = ss;
		System.out.println("Constructor: Flower(String ss), ss = " + ss);
	}
	
	Flower(String s, int petals)
	{
		this(petals);
		//! this(s); 	//Can't call two constructors.
		this.s = s;		//Another use of "this"
		System.out.println("Constructor: Flower(String s, int petals)");
	}
	
	void printPetalCount()
	{
		//! this(11); 	//Not inside non-constructor!
		System.out.println("petalCount = " + petalCount + ", s = " + s);
	}

	public static void main(String [] args)
	{
		Flower f = new Flower();
		f.printPetalCount();
	}
	
	
}
