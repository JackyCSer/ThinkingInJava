package initialization;
/*
 * Promotion of primitives and overloading
 * p79
 */

public class PrimitiveOverloading
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
	void f2(double arg)	{ System.out.println("f2(double), arg = " + arg); }
	
	void f3(short arg)		{ System.out.println("f3(short), arg = " + arg); }
	void f3(int arg)			{ System.out.println("f3(int), arg = " + arg); }
	void f3(long arg)			{ System.out.println("f3(long), arg = " + arg); }
	void f3(float arg)		{ System.out.println("f3(float), arg = " + arg); }
	void f3(double arg)	{ System.out.println("f3(double), arg = " + arg); }
	
	void f4(int arg)			{ System.out.println("f4(int), arg = " + arg); }
	void f4(long arg)			{ System.out.println("f4(long), arg = " + arg); }
	void f4(float arg)		{ System.out.println("f4(float), arg = " + arg); }
	void f4(double arg)	{ System.out.println("f4(double), arg = " + arg); }
	
	void f5(long arg)			{ System.out.println("f5(long), arg = " + arg); }
	void f5(float arg)		{ System.out.println("f5(float), arg = " + arg); }
	void f5(double arg)	{ System.out.println("f5(double), arg = " + arg); }
	
	void f6(float arg)		{ System.out.println("f6(float), arg = " + arg); }
	void f6(double arg)	{ System.out.println("f6(double), arg = " + arg); }
	
	void f7(double arg)	{ System.out.println("f7(double), arg = " + arg); }
	
	void testConstValue()
	{
		System.out.println("------------testConstValue------------");
		f1(5);
		f2(5);
		f3(5);
		f4(5);
		f5(5);
		f6(5);
		f7(5);
	}
	
	void testBoolean()
	{
		System.out.println("------------testBoolean------------");
		boolean b = true;
		f1(b);
		//f2(b);
	}
	
	void testChar()
	{
		System.out.println("------------testChar------------");
		char value = 'A';
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	void testShort()
	{
		System.out.println("------------testShort------------");
		short value = 0;
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	void testInt()
	{
		System.out.println("------------testInt------------");
		int value = 0;
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	void testLong()
	{
		System.out.println("------------testLong------------");
		long value = 0;
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	void testFloat()
	{
		System.out.println("------------testFloat------------");
		float value = 0;
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	void testDouble()
	{
		System.out.println("------------testDouble------------");
		double value = 0;
		f1(value);
		f2(value);
		f3(value);
		f4(value);
		f5(value);
		f6(value);
		f7(value);
	}
	
	public static void main(String [] args)
	{
		PrimitiveOverloading p = new PrimitiveOverloading();
		p.testConstValue();
		p.testChar();
		p.testShort();
		p.testLong();
		p.testDouble();
	}
	
}
