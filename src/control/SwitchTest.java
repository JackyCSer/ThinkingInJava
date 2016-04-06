package control;

public class SwitchTest
{
	public static void main(String[] args)
	{

		String msg = "dragon";

		switch (msg) 
		{
		case "rabbit":
			System.out.println("rabbit ");
		case "dragon":
			System.out.println("dragon");
			//break;
		default:
			System.out.println("default");
		case "monkey":
			System.out.println("monkey");
			//break;
		case "ship":
			System.out.println("ship");
		}
	}
}
