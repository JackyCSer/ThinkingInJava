package reusing;

public class SpaceShipControls
{
	void up(int velocity) { System.out.println("up: " + velocity); }
	void down(int velocity) { System.out.println("down: " + velocity); }
	void left(int velocity) { System.out.println("left: " + velocity); }
	void right(int velocity) { System.out.println("right: " + velocity); }
	void forward(int velocity) { System.out.println("forward: " + velocity); }
	void back(int velocity) { System.out.println("back: " + velocity); }
	void turboBoost() { System.out.println("turboBoost: "); }
}
