//: innerclasses/GreenhouseController.java
// Configure and execute the greenhouse system.
// {Args: 5000}
package innerclasses;


import innerclasses.controller.Event;

public class GreenhouseController
{
	public static void main(String [] args)
	{
		System.out.println(System.nanoTime() );
		
		GreenhouseControls gc = new GreenhouseControls();
		// Instead of hard-writing, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(900));
		Event [] eventList = {
				gc.new LightOn(0),
				gc.new LightOff(400),
				gc.new WaterOn(500),
				gc.new WaterOff(600)
		};
		
		gc.addEvent(gc.new Restart(20, eventList));
		if(args.length == 1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}
}
