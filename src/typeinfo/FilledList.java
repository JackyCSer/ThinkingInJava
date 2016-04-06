package typeinfo;

import java.util.ArrayList;
import java.util.List;

public class FilledList<T>
{
	private Class<T> type;

	public FilledList(Class<T> type)
	{
		this.type = type;
	}

	public List<T> create(int n)
	{
		List<T> resultList = new ArrayList<T>();
		try
		{
			for (int i = 0; i < n; i++)
			{
				resultList.add(type.newInstance());
			}
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
		return resultList;
	}

	public static void main(String[] args)
	{
		FilledList<CountedInteger> f = new FilledList<CountedInteger>(
				CountedInteger.class);

		System.out.println(f.create(5));
	}

}

class CountedInteger
{
	private static long counter;
	private final long id = counter++;

	public String toString()
	{
		return id + " " + this.getClass();
	}
}