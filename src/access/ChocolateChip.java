package access;

import access.dessert.Cookie;

public class ChocolateChip extends Cookie
{
	public ChocolateChip()
	{
		System.out.println("ChocolateChip()");
	}
	
	public void chomp()
	{
		// ! bite(); //Can't access.
	}
	
	public static void main(String [] args)
	{
		ChocolateChip cc = new ChocolateChip();
		cc.chomp();
	}
}
