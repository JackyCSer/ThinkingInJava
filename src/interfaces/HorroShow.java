package interfaces;

public class HorroShow
{
	// Strategy Design Pattern
	static void u(Monster b)
	{
		b.menace();
	}
}

interface Monster
{
	void menace();
}

interface DangerousMonster extends Monster
{
	void destory();
}

interface Lethal
{
	void kill();
}

class DragonZilla implements DangerousMonster
{

	@Override
	public void menace()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destory()
	{
		// TODO Auto-generated method stub
		
	}
	
}

interface Vampire extends DangerousMonster, Lethal
{
	void drinkBlood();
}

class VeryBadVampire implements Vampire
{

	@Override
	public void destory()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void menace()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void kill()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drinkBlood()
	{
		// TODO Auto-generated method stub
		
	}
	
}