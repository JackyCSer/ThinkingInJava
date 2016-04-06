//: innerclasses/MultiNestingAccess.java
// Nested classes can access all members of 
// all levels of the classes they are nested within.

package innerclasses;

public class MultiNestingAccess
{
	public static void main(String[] args)
	{
		MNA mna = new MNA();
		MNA.A mnaa = mna.new A(); // Using .new syntax.
		MNA.A.B mnaab = mnaa.new B(); // Using .new syntax.
		mnaab.h();
	}
}

class MNA
{
	private void f()
	{
		System.out.println("MNA.f()");
	}

	class A
	{
		private void g()
		{
			System.out.println("A.g()");
		}

		public class B
		{
			void h()
			{
				System.out.println("B.h()");
				g(); // Access outer class A's method.
				f(); // Access outer class MNA's method.
			}
		}
	}
}