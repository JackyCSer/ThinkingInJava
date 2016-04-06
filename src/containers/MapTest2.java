package containers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapTest2
{

	public static void main(String[] args)
	{
		TreeMap<Teacher, String> map = new TreeMap<Teacher, String>(new AgeComparator());

		map.put(new Teacher("a", 17), "SH");
		map.put(new Teacher("d", 19), "HZ");
		map.put(new Teacher("a", 18), "BJ");
		map.put(new Teacher("a", 18), "GZ");
		map.put(new Teacher("c", 18), "BJ");

		System.out.println(map);
		System.out.println("------------------------------------");
		Set<Teacher> keySet = map.keySet();
		Iterator<Teacher> iterator = keySet.iterator();
		while (iterator.hasNext())
		{
			Teacher teacher = iterator.next();
			System.out.println(teacher + " " + map.get(teacher));
		}
		System.out.println("------------------------------------");
		Set<Map.Entry<Teacher, String>> set = map.entrySet();
		for (Map.Entry<Teacher, String> entry : set)
		{
			System.out.println(entry);
		}
	}

}

class AgeComparator implements Comparator<Teacher>
{

	@Override
	public int compare(Teacher o1, Teacher o2)
	{
		int i = o1.age  - o2.age;
		if ( i == 0)
			return o1.name.compareTo(o2.name);
		
		return i;
	}
	
}
