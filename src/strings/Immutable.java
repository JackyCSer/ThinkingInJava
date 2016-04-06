package strings;

public class Immutable
{
	public static String upcase(String string)
	{
		return string.toUpperCase();
	}
	
	public static void main(String [] args)
	{
		String q = "howdy";
		System.out.println(q);
		String p = upcase(q);
		System.out.println(q);
		System.out.println(p);
	}

}
