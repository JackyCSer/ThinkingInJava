package initialization;
/*
 * 1. 方法f()，将会出现多态调用
 * 2.  但是，域不具有多态性
 * 3. this关键字的在构造器的中用法：
 * 	在构造超类的过程中，执行基类的构造函数时，如果在基类的构造函数中
 * 	出现this，那么它指的是超类对象的引用，如使用它调用方法，将会出现
 * 	多态调用（在本例中的f()方法），当使用它访问域时，将不会出现多态性
 * 	（域是不具有多态性的），那么将访问基类中的域，和超类无关，虽然，
 * 	此时，this指向超类。
 * 
 */
public class ThisKeywordTest
{
	public static void main(String [] args)
	{
		Litchi litchi = new Litchi("big litchi");
		System.out.println("------------------------------------------------");
		Fruit f = new Fruit();
	}

}

class Fruit
{
	private int i = 100;
	String name;
	public void f() { System.out.println("Fruit.f()"); }
	Fruit()
	{
		System.out.println("Fruit()");
		this.f();
		System.out.println("this.name = " + this.getClass().getSimpleName());
		System.out.println("this.i = " + this.i);
	}
	
	public String toString()
	{
		return name;
	}
}

class Litchi extends Fruit
{
	private int i = 200;
	Litchi(String name)
	{
		this.name = name;
		System.out.println("Litchi()");
	}
	@Override
	public void f() { System.out.println("Litchi.f()"); }

}


