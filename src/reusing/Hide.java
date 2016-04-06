package reusing;
/*
 * Overloading a base-class method name in a derived
 * class does NOT hide the base-class versions. 
 * DIFFERENT from C++. 
 */
public class Hide
{
	public static void main(String [] args)
	{
		Bart b = new Bart();
		b.doh(1);
		b.doh('x');
		b.doh(1.000201F);
		b.doh(new Milhouse() );
		
	}
}

class Homer
{
	char doh(char c)
	{
		System.out.println("doh(char)");
		return 'd';
	}
	float doh(float f)
	{
		System.out.println("doh(float)");
		return 1.0F;
	}
}

class Milhouse {}

class Bart extends Homer
{
	void doh(Milhouse m)
	{
		System.out.println("doh(Milhose)");
	}
}