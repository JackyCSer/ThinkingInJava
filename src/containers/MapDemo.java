package containers;

import java.util.HashMap;
import java.util.Map;

public class MapDemo
{
	public static void main(String[] args)
	{
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("01", "apple1");
		map.put("02", "apple2");
		map.put("03", "apple3");
		
		
		
		System.out.println(map);
//		System.out.println("map.containsKey(): " + map.containsKey("03"));
//		System.out.println("remove(): " + map.remove("02"));
//		System.out.println(map);
		
		//map.put(null, null);
		System.out.println(map.put("03", "apple4"));
		
		System.out.println(map.put("03", "apple8"));
		System.out.println(map);
		 

		
		//System.out.println(map.values());
	}
}
