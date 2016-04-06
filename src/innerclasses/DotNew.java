package innerclasses;
// Creating an inner class directly using the .new syntax

public class DotNew
{
	public class Inner 
	{
		public void f()
		{
			System.out.println("Inner.f()");
		}
	}
	
	public static class StaticInner
	{
		public void f()
		{
			System.out.println("StaticInner.f()");
		}
	}
	
	public static void main(String [] args)
	{
		DotNew dn = new DotNew();
		DotNew.Inner dni = dn.new Inner();
		DotNew.StaticInner dnsi = new StaticInner();		// When create a static inner-class instance, 
																						// do NOT need .new syntax.	
																						
		dni.f();
		dnsi.f();
	}
}
