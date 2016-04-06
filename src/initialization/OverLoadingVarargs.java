package initialization;

public class OverLoadingVarargs
{
	static void f(Character ...args)
	{
		System.out.println("f(Character ...args)");
		for(Character c : args)
			System.out.print(c + " ");
		System.out.println();
	}
	
	static void f(Integer ...args)
	{
		System.out.println("f(Integer ...args)");
		for(Integer i : args)
			System.out.print(i + " ");
		System.out.println();
	}
	
	static void f(Long ...args)
	{
		System.out.println("f(Long ...args)");
		for(Long i : args)
			System.out.print(i + " ");
		System.out.println();
	}
	
	public static void main(String [] args)
	{
		f('A', 'B', 'C');
		f(1, 2, 3);
		f(0L, 2L, 3L);
		//f();
	}
}
