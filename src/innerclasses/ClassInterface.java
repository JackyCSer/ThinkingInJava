//: innerclasses/ClassInterface.java
// {main: ClassInterface$Test}

package innerclasses;

public interface ClassInterface
{
	void howdy();
	
	// Inner class
	class Test implements ClassInterface
	{

		@Override
		public void howdy()
		{
			System.out.println("Howdy!");
		}
		
		public static void main(String [] args)
		{
			new Test().howdy();
		}
	}
}
