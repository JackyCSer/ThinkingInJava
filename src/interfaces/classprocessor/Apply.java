package interfaces.classprocessor;
/*
 * Using Strategy Design Pattern
 * 
 * The method contains the fixed part of the algorithm to be performed, 
 * and the Strategy contains the part that varies. 
 * The Strategy is the object that you pass in, ant it contains code to be executed.
 */
import java.util.Arrays;

public class Apply
{
	public static void process(Processor p, Object input)
	{
		System.out.println("Using Processor: " + p.name());
		Object temp = p.process(input); 	// Polymorphic method
		System.out.println(temp);
	}
	
	public static String s = "Disagreement with beliefs is by definition incorrect. ";
	public static void main(String [] args)
	{
		process(new Upcase(), s);			//Upcasting from Upcase to Processor
		process(new Downcase(), s);		//Upcasting from Downcase to Processor
		process(new Splitter(), s);			//Upcasting from Splitter to Processor
	}
	
}

class Processor
{
	public String name()
	{
		return getClass().getSimpleName();
	}
	Object process(Object input)
	{
		return input;
	}
}

class Upcase extends Processor
{
	@Override
	String process(Object input)
	{
		//Covariant return:
		return ((String) input).toUpperCase();
	}
}

class Downcase extends Processor
{
	@Override
	String process(Object input)
	{
		//Covariant return:
		return ((String) input).toLowerCase();
	}
}

class Splitter extends Processor
{
	@Override
	String process(Object input)
	{
		return Arrays.toString(((String) input).split(" "));
	}
}
