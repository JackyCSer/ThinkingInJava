//: innerclasses/Games.java
// Using Anonymous inner classes with the Game framework


package innerclasses;

public class Games
{
	public static void playGame(GameFactory factory)
	{
		Game g = factory.getGame();
		System.out.println("g.getClass().getSimpleName(): " + g.getClass().getSimpleName());
		while(g.move());
		
	}
	
	public static void main(String [] args)
	{
		playGame(Checkers.factory);
		playGame(Chess.factory);
	}
}

interface Game { boolean move(); }
interface GameFactory { Game getGame(); }

class Checkers implements Game
{
	private Checkers() {}
	private int moves = 0;
	private static final int MOVES = 3;
	
	@Override
	public boolean move()
	{
		System.out.println("Checkers move" + moves);
		return ++moves != MOVES;
	}
	
	public static GameFactory factory = new GameFactory()
		{
			@Override
			public Game getGame()
			{
				System.out.println("super.getClass().getSimpleName(): " 
							+ super.getClass().getSimpleName());
				System.out.println("this.getClass().getSimpleName(): " 
						+ this.getClass().getSimpleName());
				return new Checkers();
			}
		};
		
	// The same design with NO anonymous class:
	class MyGameFactory implements GameFactory
	{
		@Override
		public Game getGame()
		{
			return new Checkers();
		}
		// The field i cannot be declared static in a non-static inner type, 
		// unless initialized with a constant expression. 
		//! public static int i = 100;
		public int j = 2;
		
	}
	
	private static Checkers c = new Checkers();
	public static GameFactory factory2 = c.makeFactory();
	
	public GameFactory makeFactory()
	{
		return new MyGameFactory();
	}
}

class Chess implements Game
{
	private Chess() {}
	private int moves = 0;
	private static final int MOVES = 4;
	public boolean move()
	{
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
	public static GameFactory factory= new GameFactory() 
		{
			@Override
			public Game getGame()
			{
				return new Chess();
			}
			
		};
}