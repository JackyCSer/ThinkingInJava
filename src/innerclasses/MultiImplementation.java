//: innerclasses/MultiImplementation.java
/*
 *  With concrete or abstract classes, 
 *  inner classes are the only way to produce the effect of 
 *  "Multiple implementation inheritance". 
 */


package innerclasses;

public class MultiImplementation
{
	static void takesD(D d) {}
	static void takesE(E e) {}
	public static void main(String [] args)
	{
		Z z = new Z();
		takesD(z);
		takesE(z.makeE(1));
		// Can create many inner class's instance:
		z.makeE(2).show();
		z.makeE(3).show();
		z.makeE(4).show();
	}
}

class D { void d() {} }
abstract class E 
{ 
	private int i;
	public void show()
	{
		System.out.println("i = " + i);
	} 
	public E(int i)
	{
		this.i = i;
	}

	abstract void e(int i); 
}

class Z extends D
{
	E makeE(int i) 
	{
		return new E(i) 
		{
			@Override
			void e(int i) { System.out.println("e()"); }
		};
	}
}