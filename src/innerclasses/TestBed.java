//: innerclasses/TestBed.java
// Putting test code in a nested class. p203
// {main: TestBed$Tester}

package innerclasses;

public class TestBed
{
	public void f() { System.out.println("TestBed f()"); }
	public static class Tester
	{
		public static void main(String [] args)
		{
			TestBed tb = new TestBed();
			tb.f();
		}
	}
}
