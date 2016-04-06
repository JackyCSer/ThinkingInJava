package strings;

import java.util.Formatter;

public class FormatterDemo
{

	public static void main(String[] args)
	{
		Formatter formatter = new Formatter(System.out);
		formatter.format("%s is a string", "apple");
		
		formatter.close();
	}

}
