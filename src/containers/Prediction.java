package containers;

import java.util.Random;

public class Prediction
{
	private static Random random = new Random(47);
	private boolean shadow = random.nextDouble() > 0.5;
	
	public String toString()
	{
		if (shadow)
		{
			return "Six more weeks of Winder";
		}
		else
		{
			return "Early Spring";
		}
	}
}
