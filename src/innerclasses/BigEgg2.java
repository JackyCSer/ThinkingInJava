//: innerclasses/BigEgg2.java
// Proper inheritance of an inner class.
package innerclasses;

public class BigEgg2 extends Egg2
{
	public class Yolk extends Egg2.Yolk
	{
		public Yolk() { System.out.println("BigEgg2.Yolk()"); }
		@Override
		public void f() { System.out.println("BigEgg2.Yolk.f()"); }
		
	}

	public BigEgg2() 
	{ 
		insertYolk(new Yolk());  // Upcasting from BigEgg2.Yolk to Egg2.Yolk
	}
	
	public static void main(String [] args)
	{
		Egg2 e2 = new BigEgg2();		// Upcasting to Egg2
		e2.g();
		
	}
	
	
}

class Egg2
{
	protected class Yolk
	{
		public Yolk() { System.out.println("Egg2.Yolk()"); }
		public void f() { System.out.println("Egg2.Yolk.f()"); }
		
	}
	private Yolk y = new Yolk();
	public Egg2() { System.out.println("New Egg2()"); }
	public void insertYolk(Yolk yy) { y = yy; }
	public void g() { y.f(); }
	
}