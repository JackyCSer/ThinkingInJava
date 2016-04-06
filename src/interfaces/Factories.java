package interfaces;
// Factory Method Design Pattern

public class Factories
{
	public static void main(String [] args)
	{
		serviceConsumer(new Implementation1Factory());
		// Implementations are completely interchangeable:
		serviceConsumer(new Implementation2Factory());
	}

	private static void serviceConsumer(ServiceFactory sf)
	{
		Service s = sf.getService();
		s.method1();
		s.method2();
	}
}

interface Service
{
	void method1();
	void method2();
}

interface ServiceFactory
{
	Service getService();
}

class Implementation1 implements Service
{
	Implementation1() {}
	@Override
	public void method1() { System.out.println("Implementation1 method1()"); }
	
	@Override
	public void method2() { System.out.println("Implementation1 method2()"); }
}

class Implementation1Factory implements ServiceFactory
{

	@Override
	public Service getService()
	{
		System.out.println(this.getClass().getSimpleName());
		// TODO Auto-generated method stub
		return new Implementation1();
	}
	
}

class Implementation2 implements Service
{
	Implementation2() {}		// Package access
	@Override
	public void method1() { System.out.println("Implementation2 method1()"); }
	
	@Override
	public void method2() { System.out.println("Implementation2 method2()"); }
	
}

class Implementation2Factory implements ServiceFactory
{

	@Override
	public Service getService()
	{
		System.out.println(this.getClass().getSimpleName());
		// TODO Auto-generated method stub
		return new Implementation2();
		
	}
	
}








