package polymorphism.shape;

public class Square extends Shape
{
	@Override
	public void draw() { System.out.println(this.getClass().getSimpleName() + ".draw()"); }
	public void erase() { System.out.println(this.getClass().getSimpleName() + ".erase()"); }
}
