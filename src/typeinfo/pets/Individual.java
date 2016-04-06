package typeinfo.pets;

public class Individual
{
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public Individual()
	{

	}
	
	public Individual(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return this.getClass().getSimpleName();
	}
}
