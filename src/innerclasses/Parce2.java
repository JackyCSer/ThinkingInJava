package innerclasses;
// Returning a reference to an inner class.

public class Parce2
{
	class Contents
	{
		private int i = 11;
		public int value() { return i;}
	}
	
	class Destination
	{
		private String label;
		Destination(String whereTo)
		{
			label = whereTo;
		}
		
		String readLabel() { return label; }
	}
	
	public Destination to(String s)
	{
		return new Destination(s);
	}
	
	public Contents contents()
	{
		return new Contents();
	}
	
	public void ship(String dest)
	{
		Contents c = contents();
		Destination d = to(dest);
		System.out.println(d.readLabel());
		
	}

	public static void main(String [] args)
	{
		Parce2 p = new Parce2();
		p.ship("Tasmania");
		Parce2 q = new Parce2();
		// Defining references to inner classes:
		Parce2.Contents c = q.contents();
		Parce2.Destination d = q.to("Borneo");
		
	}
}

