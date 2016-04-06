package containers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo2
{

	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();

		map.put("01", "apple1");
		map.put("02", "apple2");
		map.put("03", "apple3");
		
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> iterator  = entrySet.iterator();
		
		while (iterator.hasNext())
		{
			Map.Entry<String, String> entry = iterator.next();
			
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}


	}

}
