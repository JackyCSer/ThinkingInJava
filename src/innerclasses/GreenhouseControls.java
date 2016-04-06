package innerclasses;

import innerclasses.controller.Controller;
import innerclasses.controller.Event;

public class GreenhouseControls extends Controller
{
	// Control objects:
	private boolean light  = false;
	private boolean water = false;
	
	public void f() { System.out.println("Outer-class method: f()"); }
	
	
	// Inner classes as Functions:
	public class LightOn extends Event
	{
		public LightOn(long delayTime)
		{
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action()
		{
			f();
			// Put hardware control code here to
			// physically turn on the light.
			light = true;
		}
		
		public String toString() { return "Light is on."; }
	}
	
	public class LightOff extends Event
	{

		public LightOff(long delayTime)
		{
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action()
		{
			// Put hardware control code here to physically turn off the light.
			light = false;
		}
		public String toString() { return "Light is off."; }
		
	}
	
	public class WaterOn extends Event
	{

		public WaterOn(long delayTime)
		{
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action()
		{
			// Put hardware control code here.
			water = true;
		}
		
		public String toString() { return "Greenhouse water is on."; }
	}
	
	public class WaterOff extends Event
	{

		public WaterOff(long delayTime)
		{
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action()
		{
			// Put hardware control code here.
			water = false;
		}
		
		public String toString() { return "Greenhouse water is off."; }
	}
	
	// An example of an action() that inserts a new one of itself into the event list:
	public class Bell extends Event
	{

		public Bell(long delayTime)
		{
			super(delayTime);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void action()
		{
			addEvent(new Bell(delayTime));
		}
		public String toString() { return "Bing"; }
	}
	
	public class Restart extends Event
	{
		private Event[] eventList;
		
		public Restart(long delayTime, Event[] eventList)
		{
			super(delayTime);
			this.eventList = eventList;
			for(Event e : eventList)
			{
				e.start();	// Rerun this event.
				addEvent(e);
			}
		
		}

		@Override
		public void action()
		{
			for(Event e : eventList)
			{
				e.start();	// Rerun each event.
				addEvent(e);
			}
			start();		// Rerun this event.
			addEvent(this);
		}
		
		public String toString() { return "Restarting System."; }
	}
	
	public static class Terminate extends Event
	{

		public Terminate(long delayTime)
		{
			super(delayTime);
		}

		@Override
		public void action()
		{
			System.exit(0);
		}
		
		public String toString() { return "Terminating"; }
	}
	
}
