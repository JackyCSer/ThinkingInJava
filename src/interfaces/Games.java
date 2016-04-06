package interfaces;

// A Game framework using Factory Method Design Pattern

public class Games
{
	public static void playGame(GameFactory factory)
	{
		Game g = factory.getGame();
		while(g.move())
		{
			System.out.println("Moving...");
		}
	}
	
	public static void main(String [] args)
	{
		playGame(new CheckersFactory());
		playGame(new ChessFactory());
	}
	
}

interface Game
{
	boolean move();
}

interface GameFactory 
{
	Game getGame();
}

class Checkers implements Game
{
	private int moves = 0;
	private static final int MOVES = 6;
	
	@Override
	public boolean move()
	{
		System.out.println("Checkers move " + moves);
		return ++ moves != MOVES;
	}

}

class CheckersFactory implements GameFactory
{

	@Override
	public Game getGame()
	{
		return new Checkers();		// Upcasting from class: Checkers to interface: Game
	}
	
}

class Chess implements Game
{
	private int moves = 0;
	private static final int MOVES = 4;
	
	@Override
	public boolean move()
	{
		System.out.println("Chess move " + moves);
		return ++moves != MOVES;
	}
}

class ChessFactory implements GameFactory
{
	@Override
	public Game getGame()
	{
		return new Chess();
	}
	
}



















