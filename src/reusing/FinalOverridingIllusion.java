package reusing;
/*
 * It only looks like you can override a private or private final method
 * BUT it is wrong.
 */
public class FinalOverridingIllusion
{
	public static void main(String [] args)
	{
		OverridingPrivate2 op2 = new OverridingPrivate2();
		op2.f();
		op2.g();
		// Upcasting
		OverridingPrivate op = op2;
		// But can't call the methods
		
		
	}
}

class WithFinals
{
	// Identical to "private" alone
	private final void f()
	{
		System.out.println("WithFinals.f()");
	}
	// Also automatically "final"
	private void g()
	{
		System.out.println("WithFinals.g()");
	}
}

class OverridingPrivate extends WithFinals
{
	// NOT override, just create a new method
	private final void f()
	{
		System.out.println("OverridingPrivate.f()");
	}
	private void g()
	{
		System.out.println("OverridingPrivate.g()");
	}
}

class OverridingPrivate2 extends OverridingPrivate
{
	// NOT override, just create a new method
	public final void f()
	{
		System.out.println("OverridingPrivate2.f()");
	}
	public void g()
	{
		System.out.println("OverridingPrivate2.g()");
	}
}



