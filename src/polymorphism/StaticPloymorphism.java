package polymorphism;
// Static method are NOT polymorphic
public class StaticPloymorphism
{
	public static void main(String [] args)
	{
		StaticSuper sup = new StaticSub(); //Upcasting
		System.out.println(sup.getClass().getSimpleName());
		System.out.println(sup.staticGet());
		System.out.println(sup.dynamicGet());
		//System.out.println(sup.i);
	}
}

class StaticSuper
{
	public static String staticGet()
	{
		return "Base staticGet()";
	}
	
	public String dynamicGet()
	{
		return "Base dynamicGet()";
	}
}

class StaticSub extends StaticSuper
{
	static int i = 100;
	
	public static String staticGet()
	{
		return "Derived staticGet()";
	}
	public String dynamicGet()
	{
		return "Derived dynamicGet()";
	}
}