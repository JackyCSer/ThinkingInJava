package typeinfo.pets;

public class Pet extends Individual implements Comparable<Pet>
{
	public Pet(String name)
	{
		super(name);
	}

	public Pet()
	{
		super();
	}

	
	@Override
	public int compareTo(Pet o)
	{
		return this.getClass().getSimpleName().length() - 
				o.getClass().getSimpleName().length() ;
	}
}
