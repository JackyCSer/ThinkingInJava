package containers;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class SpringDetector
{
	public static <T extends Groundhog> void detectSpring(Class<T> type)
			throws Exception
	{
		Constructor<T> constructor = type.getConstructor(int.class);
		Map<Groundhog, Prediction> map = new HashMap<Groundhog, Prediction>();
		for (int i = 0; i < 10; i++)
		{
			map.put(constructor.newInstance(i), new Prediction());
		}
		System.out.println("map = " + map);

	}
	
	public static void main(String [] args) throws Exception
	{
		detectSpring(Groundhog.class);
		
	}
}
