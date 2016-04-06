package polymorphism;
// Constructors and polymorphism don't produce what you might expect.

public class PolyConstructors
{
	private Apple a = new Apple("PolyConstructors.apple");
	private static Apple sa = new Apple("PolyConstructors.staticApple");
	
	public static void main(String [] args)
	{
		System.out.println("---------main---------");
		new RoundGlyph(5);
	}
}

class Glyph
{
	private Apple a = new Apple("Glyph.apple");
	private static Apple sa = new Apple("Glyph.staticApple");
	
	void draw() { System.out.println("Glyph.draw()"); }
	Glyph()
	{
		System.out.println("-----------Glyph()-------------");
		System.out.println("Glyph() before draw()");
		System.out.println(this.getClass().getSimpleName() );
		draw();
		System.out.println("Glyph() after draw()");
		System.out.println("-----------END Glyph()-------------");
	}
}

class RoundGlyph extends Glyph
{
	private Apple a = new Apple("RoundGlyph.apple");
	private static Apple sa = new Apple("RoundGlyph.staticApple");
	
	private Radius radius = new Radius(1);
	RoundGlyph(int r)
	{
		System.out.println("------------RoundGlyph(int r)---------------");
		radius.setRaidus(r);
		System.out.println("RoundGlyph.RoundGlyph(), radius = " + radius);
		System.out.println("------------END RoundGlyph(int r)------------");
	}
	@Override
	void draw()
	{
		System.out.println("RoundGlyph.draw(), radius = " + radius);
	}
}

class Apple
{
	private String name;
	Apple(String s)
	{
		name = s;
		System.out.println("Apple("+s+")");
	}
	public String toString()
	{
		return name;
	}
}

class Radius
{
	int r;
	Radius(int r)
	{
		this.r = r;
		System.out.println("Radius("+r+")");
	}
	public String toString()
	{
		return r+"";
	}
	public void setRaidus(int r)
	{
		this.r  = r;
	}
}