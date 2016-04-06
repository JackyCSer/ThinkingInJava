package innerclasses;

public class TestParcel
{
	public static void main(String args)
	{
		Parcel4 p = new Parcel4();
		Contents c = p.contents();
		Destination d = p.destination("Provnece");
		
		// Can access protected Parcel4.PDestination because it also provides package access:
		Parcel4.PDestination ppd = p.new PDestination("Provence");		
		
		// The type Parcel4.PContents is not visible
		//! Parcel4.PContents pc = p.new PContents();
	}
}

class Parcel4
{
	private class PContents implements Contents
	{
		private int i = 11;
		@Override
		public int value()
		{
			// TODO Auto-generated method stub
			return i;
		}
		
	}
	
	protected class PDestination implements Destination
	{
		private String label;
		PDestination(String whereTo)
		{
			label = whereTo;
		}
		
		@Override
		public String readLabel()
		{
			// TODO Auto-generated method stub
			return label;
		}
		
	}
	
	public Destination destination(String s)
	{
		return new PDestination(s);		// Upcasting to Destination
	}
	
	public Contents contents()
	{
		return new PContents();			// Upcasting to Contents
	}
}