package initialization;
// p103
public class VarAgrType
{
	static void f(Character ...args)
	{
		System.out.print(args.getClass());
		System.out.println("length = " + args.length);
	}
	
	static void g(int ...args)
	{
		System.out.print(args.getClass());
		System.out.println("length = " + args.length);
	}
	
	public static void main(String [] args)
	{
		f('A');
		f();
		g(1);
		g();
		System.out.println("int []: " + new int[0].getClass());
		new Orange();
		System.gc();
	}
	
	
}

class Orange
{
	@Override
	protected void finalize()
	{
		System.out.println("Unused variable...");
	}
}