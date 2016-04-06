package polymorphism;

public class PrivateOverride
{
	int i = 100;
	private void f() { System.out.println("private f()"); }
	void g() { System.out.println("PrivateOverride: g()"); }
	
	public static void main(String [] args)
	{
		
		PrivateOverride p = new Derived();
		
		Derived d = new Derived();
		p.f();
		d.f();
		
		System.out.println(p.getClass().getSimpleName());
		
		System.out.println(d.getClass().getSimpleName());
		System.out.println("-----------Test fields----------");
		System.out.println("p.i = " + p.i);
		System.out.println("d.i = " + d.i);
		System.out.println("d.j = " + d.j);
		System.out.println("-----------Test methods----------");
		p.g();
		d.g();
		d.h();
	}
}

class Derived extends PrivateOverride
{
	int i = 101;
	int j = 200;
	public void f() { System.out.println("public f()"); }
	void g() { System.out.println("Derived: g()"); }
	void h() { System.out.println("Derived: h()"); }
}