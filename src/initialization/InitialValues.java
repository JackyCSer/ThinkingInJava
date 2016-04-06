package initialization;

public class InitialValues
{
	boolean t;
	char c;
	byte b;
	short s;
	int i;
	long l;
	double d;
	InitialValues reference;
	
	void printInitialValues()
	{
		System.out.println("Data type \t Initial vlaue");
		
		System.out.println("boolean: \t"+t);
		System.out.println("char: \t"+c);
		System.out.println("byte: \t"+b);
		System.out.println("short: \t"+s);
		System.out.println("int: \t\t"+i);
		System.out.println("long: \t"+l);
		System.out.println("double: \t"+d);
		System.out.println("reference: \t"+reference);
	}
	
	public  static void main(String [] args)
	{
		InitialValues iv = new InitialValues();
		iv.printInitialValues();
	}
}
