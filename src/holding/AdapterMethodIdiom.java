package holding;

import java.util.*;

public class AdapterMethodIdiom
{
	public static void main(String [] args)
	{
		ReversibleArrayList<String> ral = 
				new ReversibleArrayList<String>
		(Arrays.asList("To be or not to be".split(" ")));
		// Grabs the ordinary iterator via iterator():
		for(String s: ral)
			System.out.print(s + " ");
		System.out.println();
		// Hand it the Iterator of your choice:
		for(String s : ral.reversed())
			System.out.print(s + " ");
		System.out.println();
	}

	
	
	
}

class ReversibleArrayList<T> extends ArrayList<T>
{
	public ReversibleArrayList(Collection<T> c)
	{
		super(c);
	}
	public Iterable<T> reversed()
	{
		// Anonymous inner class:
		return new Iterable<T>()
				{
					@Override
					public Iterator<T> iterator()
					{ // Anonymous inner class:
						return new Iterator<T>()
								{
									int current = size() - 1;
									public boolean hasNext() { return current > -1;}
									public T next() { return get(current--); }
									public void remove() 
									{ //Not implemented
										throw new UnsupportedOperationException();
									}
								};
					}
				};
	}
}