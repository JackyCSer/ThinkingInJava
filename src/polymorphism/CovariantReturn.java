package polymorphism;

public class CovariantReturn
{
	public static void main(String [] args)
	{
		Mill  m = new Mill();
		m = new WheatMill();		//Upcasting to Mill
		
		System.out.println("m = "+m.getClass().getSimpleName());
		System.out.println();
		
		//Upcasting from Wheat to Grain:
		Grain g = m.process();	//return Wheat
		System.out.println(g);

	}
}

class Grain
{
	public String toString()
	{
		return "Grain";
	}
}

class Wheat extends Grain
{
	public String toString()
	{
		return "Wheat";
	}
}

class Mill
{
	Grain process()
	{
		System.out.println("Call: Mill.process()");
		return new Grain();
	}
}

class WheatMill extends Mill
{
	@Override
	Wheat process()
	{
		System.out.println("Call: WheatMill.process()");
		return new Wheat();
	}
	@Override
	public String toString()
	{
		return "WheatMill";
	}
	
}



