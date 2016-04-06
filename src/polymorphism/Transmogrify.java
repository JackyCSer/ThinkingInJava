package polymorphism;
/*
 * Using polymorphism to dynamically changing the behavior of an object
 * via composition (the "State" design pattern)
 */
public class Transmogrify
{
	public static void main(String [] args)
	{
		Stage stage = new Stage();
		stage.performPlay();
		stage.change();
		stage.performPlay();
		stage.change();
		stage.performPlay();
	}
}

class Actor
{
	public void act() {}
}

class HappyActor extends Actor
{
	@Override
	public void act() { System.out.println("HappyActor.act()"); }
}

class SadActor extends Actor
{
	@Override
	public void act() { System.out.println("SadActor.act()"); }
}

class Stage
{
	private Actor actor = new HappyActor();	//Upcasting
	
	public void change() 
	{ 
		if (actor.getClass().getSimpleName().equals("HappyActor"))
			actor = new SadActor(); 
		else
			actor = new HappyActor();
	}
	
	public void performPlay() 
	{
		actor.act();	// Polymorphic method
	}
}








