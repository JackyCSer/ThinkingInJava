package initialization;
// Demotion of primitives and overloading

public class Demotion
{
	void f1(boolean arg) 	{ System.out.println("f1(boolean), arg = " + arg); }
	void f1(byte arg)			{ System.out.println("f1(byte), arg = " + arg); }
	void f1(char arg)		{ System.out.println("f1(char), arg = " + arg); }
	void f1(short arg)		{ System.out.println("f1(short), arg = " + arg); }
	void f1(int arg)			{ System.out.println("f1(int), arg = " + arg); }
	void f1(long arg)			{ System.out.println("f1(long), arg = " + arg); }
	void f1(float arg)		{ System.out.println("f1(float), arg = " + arg); }
	void f1(double arg)	{ System.out.println("f1(double), arg = " + arg); }
	
	void f2(byte arg)			{ System.out.println("f2(byte), arg = " + arg); }
	void f2(char arg)		{ System.out.println("f2(char), arg = " + arg); }
	void f2(short arg)		{ System.out.println("f2(short), arg = " + arg); }
	void f2(int arg)			{ System.out.println("f2(int), arg = " + arg); }
	void f2(long arg)			{ System.out.println("f2(long), arg = " + arg); }
	void f2(float arg)		{ System.out.println("f2(float), arg = " + arg); }
	
	void f3(short arg)		{ System.out.println("f3(short), arg = " + arg); }
	void f3(int arg)			{ System.out.println("f3(int), arg = " + arg); }
	void f3(long arg)			{ System.out.println("f3(long), arg = " + arg); }
	
	void f4(int arg)			{ System.out.println("f4(int), arg = " + arg); }
	void f4(long arg)			{ System.out.println("f4(long), arg = " + arg); }
	void f4(float arg)		{ System.out.println("f4(float), arg = " + arg); }
	
	void f5(long arg)			{ System.out.println("f5(long), arg = " + arg); }
	void f5(short arg)		{ System.out.println("f5(short), arg = " + arg); }
	
	void f6(byte arg)			{ System.out.println("f6(byte), arg = " + arg); }
	
	void f7(char arg)	{ System.out.println("f7(char), arg = " + arg); }
	
	void testDouble()
	{
		System.out.println("------------testDouble------------");
		double value = 65;
		
		f1(value);
		f2( (float) value);
		f3( (long) value);
		f4( (int) value);
		f5( (short) value);
		f6( (byte) value);
		f7( (char) value);
	}
	
	public static void main(String [] args)
	{
		Demotion d = new Demotion();
		d.testDouble();
	}

}
