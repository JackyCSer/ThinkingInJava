package innerclasses;
// Returning an instance of an anonymous inner class.

public class Parcel7
{
	public Contents contents()
	{
		return new Contents()
		{
			// Insert a class definition.
			private int i = 11;
			public int value() { return i; }
		};		// The end of the "return expression".
	}
	
	public static void main(String [] args)
	{
		Parcel7 p = new Parcel7();
		Contents c = p.contents();
		
	}
}
