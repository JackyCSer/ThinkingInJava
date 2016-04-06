package polymorphism.shape;

public class Shape
{
	public void draw() 
	{ 
		System.out.println("Shape.draw()"); 
	}
	public void erase() { System.out.println(this.getClass().getSimpleName() + ".draw()"); }
}
