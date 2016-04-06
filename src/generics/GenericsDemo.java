package generics;

public class GenericsDemo
{
	 
	public static void main(String[] args)
	{
		Fruit<Apple> fruit = new FruitImpl<Apple>();
		
		fruit.show(new Apple());

	}
}

interface Fruit<T>
{
	void show(T t);
}

class FruitImpl<T> implements Fruit<T>
{

	@Override
	public void show(T t)
	{
		System.out.println("show: " + t);
		
	}
	
}

class Demo<T>
{
	
	public <T2> void show(T2 t)
	{
		System.out.println("show: " + t);
	}
	
	public void print(T e)
	{
		System.out.println("print: " + e);
	}
	
	public static <A> void f(A a)
	{
		System.out.println("static f() " + a);
	}
}

class Apple
{
	String name;

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}