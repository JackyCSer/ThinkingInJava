package initialization;
// p107
// Using enum type in a switch expression.
public class Burrito
{
	Spiciness degree;
	public Burrito(Spiciness degree)
	{
		this.degree = degree;
	}
	
	public void describe()
	{
		System.out.print("This burrito is :");
		switch(degree)
		{
		case FLAMING:
			System.out.println(degree);
			break;
		case HOT:
			System.out.println(degree);
			break;
		case MEDIUM:
			System.out.println(degree);
			break;
		case MILD:
			System.out.println(degree);
			break;
		case NOT:
			System.out.println(degree);
			break;
		default:
			System.out.println("This is a new Burrito. ");
			break;
			
		}
		
	}
	
	public static void main(String [] args)
	{
		Burrito plain = new Burrito(Spiciness.NOT);
		Burrito greenChile = new Burrito(Spiciness.HOT);
		
		plain.describe();
		greenChile.describe();
	}
	
}
