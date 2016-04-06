package innerclasses;

public class Parce3
{
	class Contents
	{
		private int i = 11;
		public int value() { return i; }
	}
	
	class Destination
	{
		private String label;
		Destination(String whereTo) { label = whereTo; }
		String readLabel() { return label; }
		
	}
	
	public static void mian(String [] args)
	{
		Parce3 p = new Parce3();
		// Must use instance of outer class to create an instance of the inner class:
		Parce3.Contents c = p.new Contents();
		Parce3.Destination d = p.new Destination("Provence");
		
	}
}
