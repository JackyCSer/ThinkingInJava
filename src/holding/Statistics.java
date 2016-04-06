package holding;

import java.util.*;

public class Statistics
{
	public static void main(String [] args)
	{
		Random rand = new Random(47);
		Map<Integer, Double> map = new HashMap<Integer, Double>();
		for(int i = 0; i < 100; i++ )
		{
			int r = rand.nextInt(10);
			Double frequence = map.get(r);
			map.put(r, frequence == null ? 1/100 : (frequence + 1) /100);
			
		}
		System.out.println(map);
	}
}
