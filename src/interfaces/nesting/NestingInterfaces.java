package interfaces.nesting;
/*
 * p186
 * getD()方法使我们陷入了一个进退两难的境地，
 */
import interfaces.nesting.A.DImp2;

public class NestingInterfaces
{
	public class BImp implements A.B
	{
		@Override
		public void f() {}
	}
	
	class CImp implements A.C
	{
		@Override
		public void f() {}
	}
	
	// Cannot implement a private interface except within that interface's
	// defining class:
	/*
	class DImp implements A.D
	{
		
	}
	*/
	
	class EImp implements E
	{

		@Override
		public void g() {}
		
	}
	
	class EGImp implements E.G
	{

		@Override
		public void f() {}
		
	}
	
	class EImp2 implements E
	{

		@Override
		public void g() {}
		
		class EG implements E.G
		{

			@Override
			public void f() {}
			
		}
	}
	
	public static void mian(String [] args)
	{
		A a = new A();
		// Can't access A.D
		//! A.D ad = a.getD();
		// Doesn't return anything but A.D
		// Type mismatch: cannot convert from A.D to A.DImp2
		A.DImp2 di2 = (DImp2) a.getD();
		// Cannot access a  member of the interface: The type A.D is not visible
		//! a.getD().f();
		// Only another A can do anything with getD():
		A a2 = new A();
		a2.receiveD(a.getD());
		
		
	}
}

class A
{
	// Automatically public
	abstract interface B
	{
		public abstract void f();
	}
	
	public class BImp implements B
	{
		@Override
		public void f() {}
	}
	
	private class BImp2 implements B
	{

		@Override
		public void f() {}
		
	}
	
	public abstract interface C
	{
		void f();
	}
	
	class CImp implements C
	{

		@Override
		public void f() {}
		
	}
	
	private class CImp2 implements C
	{
		@Override
		public void f() {}
		
	}
	
	private interface D 
	{
		void f();
	}
	
	private class DImp implements D
	{

		@Override
		public void f() {}
		
	}
	
	public class DImp2 implements D
	{
		@Override
		public void f() {}
	}
	
	public D getD() 
	{ 
		return new DImp2(); // Upcasting form DImp2 to D
	}
	private D dRef;
	public void receiveD (D d)
	{
		dRef = d;
		dRef.f();
	}
}

abstract interface E
{
	interface G
	{
		void f();
	}
	
	// Redundant "public"
	public abstract interface H
	{
		void f();
	}
	
	void g();
	// Cannot be private within an interface:
	// The interface member type I can only be public
	// ! private interface I {}
}



