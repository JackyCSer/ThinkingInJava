package interfaces.interfaceprocessor;
/*
 * Using Strategy Design Pattern
 * The method contains the fixed part of the algorithm to be performed, 
 * and the Strategy contains the part that varies. 
 * The Strategy is the object that you pass in, ant it contains code to be executed.
 * In the class Apply, the Processor is an interface, and it has it's method to be executed. 
 */
public class Apply
{
	// Using interface instead of class as argument.
	public static void process(Processor p, Object input)
	{
		System.out.println("Using Processor " + p.name());
		System.out.println(p.process(input));
	}
}
