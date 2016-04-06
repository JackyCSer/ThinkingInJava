package innerclasses;
// An anonymous inner class that performs initialization.
// A better version of Parcel5.java

public class Parcel9
{
	// Argument must be final to use inside anonymous inner class:
	// Argument: i do NOT need to be final 
	public Destination destination(final String dest, int i)
	{
		return new Destination()
		{
			private String label = dest;
			public String readLabel() { return label; }
		};
	}
	
	public static void main(String [] args)
	{
		Parcel9 p = new Parcel9();
		Destination d = p.destination("Provence", 100);
	}
}
