package innerclasses;
// Nesting a class within a method.

public class Parcel5
{
	public Destination destination(String s)
	{
		class PDestination implements Destination
		{
			private String label;
			@Override
			public String readLabel()
			{
				return label;
			}
			
			private PDestination(String whereTo)
			{
				label = whereTo;
			}
		}
		
		return new PDestination(s);		// Return inner class's instance and Upcasting to Destination.
	}
	
	public static void main(String [] args)
	{
		Parcel5 p = new Parcel5();
		Destination d = p.destination("Provence");
		
	}
}

