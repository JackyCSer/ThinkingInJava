package containers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest3
{

	public static void main(String[] args)
	{
		String string = "abcda";
		char[] array = string.toCharArray();
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();

		for (int i = 0; i < array.length; i++)
		{
			char c = array[i];

			if (!map.containsKey(c))
			{
				map.put(c, 1);
			} else
			{
				int t = map.get(c);
				t++;
				map.put(c, t);
			}
		}
		
		Set<Map.Entry<Character, Integer>> set = map.entrySet();
		for (Map.Entry<Character, Integer> entry : set)
		{
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}

	}

}
