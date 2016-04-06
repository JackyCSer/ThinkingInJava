//: innerclasses/Parcel11.java
// Nested classes (static inner classes).


package innerclasses;

public class Parcel11
{
	private static class ParcelContents implements Contents
	{
		private int i = 11;
		@Override
		public int value()
		{
			return i;
		}
	}
	
	protected static class ParcelDestination implements Destination
	{
		private String label;
		@Override
		public String readLabel()
		{
			return label;
		}
		private ParcelDestination(String whereTo)
		{
			label = whereTo;
		}
		
		// Nested classes can contain other static elements:
		public static void f() {}
		static int x = 10;
		
		static class AnotherClass
		{
			public static void f() {}
			static int x = 12;
		}
	}
	
	public static Destination destination(String s)
	{
		// Upcasting to interface Destination:
		return new ParcelDestination(s);
	}
	
	public static Contents contents()
	{
		// Upcasting to interface Contents:
		return new ParcelContents();
	}
	
	public static ParcelDestination.AnotherClass getAnotherClass()
	{
		return new ParcelDestination.AnotherClass();
	}
	
	public static void main(String [] args)
	{
		Contents c = contents();
		Destination d = destination("Provence");
		ParcelDestination.AnotherClass pa = getAnotherClass();
		
	}
	
}

