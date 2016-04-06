package reusing;
// The full process of initialization

public class Beetle extends Insect
{
	private int k = printInit("Beetle.k initialized. ");
	
	public Beetle()
	{
		System.out.println("Beetle()");
		System.out.println("k = " + k); // Beetle.k
		System.out.println("j = " + j);  // Insect.j
	}
	
	private static int x2 = printInit("static Beetle.x2 initialized. ");
	
	public static void main(String [] args)
	{
		System.out.println("main()");
		Beetle b = new Beetle();
	}
}

class Insect
{
	private int i = 9;
	protected int j;
	
	Insect()
	{
		System.out.println("Insect()");
		System.out.println("i = " + i + ", j = " + j);
		j = 39;
	}
	
	private static int x1 = printInit("static Insect.x1 initialized. ");
	
	static int printInit(String s)
	{
		System.out.println(s);
		return 47;
	}
}