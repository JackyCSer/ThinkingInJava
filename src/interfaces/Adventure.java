package interfaces;
// Multiply interfaces.

public class Adventure
{
	
	public static void t(CanFight x) { x.fight(); }
	public static void u(CanSwim x) {x.swim(); }
	public static void v(CanFly x) {x.fly(); }
	public static void w(ActionCharacter x) { x.fight(); }
	public static void main(String [] args)
	{
		Hero h = new Hero();
		t(h);		// Treat h as a CanFight, Upcasting from Hero to CanFight
		u(h);	// Treat h as a CanSwim
		v(h);		// Treat h as a CanFly
		w(h);	// Treat h as a ActionCharacter
		
		
	}
}

interface CanFight
{
	public abstract void fight();
}

interface CanSwim
{
	void swim();
}

interface CanFly
{
	void fly();
}

class ActionCharacter
{
	public void fight() {System.out.println("fight...");}
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly
{

	@Override
	public void fly()
	{
		System.out.println("fly...");
		
	}

	@Override
	public void swim()
	{
		System.out.println("swim...");
		
	}
	
}