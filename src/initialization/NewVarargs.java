package initialization;

public class NewVarargs
{
	static void printArray(Object ...args)
	{
		for(Object obj : args)
		{
			System.out.print(obj + " ");
		}
		System.out.println();
	}
	
	static void printArray2(Object [] args)
	{
		for(Object obj : args)
		{
			System.out.print(obj + " ");
		}
		System.out.println();
	}
	
	public static void main(String [] args )
	{
		printArray(new Integer(47), new Float(3.14), new Double(11.123) );
		printArray((Object []) new Integer [] {1, 2, 3, 4, 5});
		Integer [] i;
		i = new Integer[] {1, 2, 3, 4, 5};
		Integer [] ii = {1, 2, 3, 4, 5};
		Integer [] iii = new Integer[] {1, 2, 3, 4, 5};
		printArray(i);
		printArray2(i);
	}
}
