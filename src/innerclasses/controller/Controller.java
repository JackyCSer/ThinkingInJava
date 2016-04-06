//: innerclasses/controller/Controller.java
// The reusable framework for control systems.

package innerclasses.controller;


import java.util.ArrayList;
import java.util.List;

// A class from java.util to hold Event objects:
public class Controller
{
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event e) { eventList.add(e); }
	public void run()
	{
		while(eventList.size() > 0)
		{
			// Make a copy so you're not modifying the list
			// while you are selecting the elements in it:
			for (Event e : new ArrayList<Event>(eventList))
				if(e.ready())
				{
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
		}
	}
}
