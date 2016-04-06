package innerclasses;
// Qualifying access to the outer-class object

public class DotThis
{
	void f() { System.out.println("DotThis.f() "); }
	
	public class Inner
	{
		public DotThis outer()
		{
			//! return this; 		// A plain "this" would be Inner's "this".
			return DotThis.this;		// return outer-class's reference.
		}
		
	}
	
	public Inner inner() { return new Inner(); }
	
	public static void main(String [] args)
	{
		DotThis dt = new DotThis();
		DotThis.Inner dti = dt.inner();
		dti.outer().f();
	}
	
}
