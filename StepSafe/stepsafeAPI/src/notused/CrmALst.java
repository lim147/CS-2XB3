package notused;

import java.util.ArrayList;
import java.util.List;

import types.Event;

/**
 *  The {@code CrmALst} class is an object that holds the list of Crime Events relevant to user input
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  @version 1.0
 *  @since 2019-04-03
 */

public class CrmALst {
	private int i; //counter
	private List<Event> lst;
	
    /**
     * Constructor for a list of Crime events
     */
	public CrmALst() {
		this.i = 0;
		this.lst = new ArrayList<Event>();
		
	}
	
    /**
     * Mutator where a crime event is added to the list
     *
     * @param  e the event being added
     */
	public void addEvent(Event e) {
		lst.add(e);
	}
	
    /**
     * Mutator where the increment counter is set to 0
     */
	public void start() {
		i = 0;
	}

    /**
     * Mutator where an event at an index is set to be another event
     * 
     * @param index the index of the array to be changed
     * @param e the event to be put into the array at the index given
     */
	public void set(int index, Event e) {
		lst.add(index, e);
	}

    /**
     * Accessor to event in the list
     * 
     * @param index the index of the event desired
     * @return event at the index provided
     */
	public Event get(int index) {
		return lst.get(index);
	}
	
    /**
     * Accessor that gets the array item at current index value
     *
     * @return Event at the current index
     */
	public Event current() {
		return lst.get(i);
	}
	
    /**
     * Increments the index counter and returns the Event at the 
     * previous index
     *
     * @return Event at the index when the method is called
     */
	public Event next() {
		i++;
		return lst.get(i-1);
	}
	
    /**
     * Checks to see if the index value is at the end of the list
     *
     * @return boolean indicating if index value is at the end of 
     * the list
     */
	public boolean end() {
		if (i == lst.size())
			return true;
		else
			return false;
	}

    /**
     * Prints out events in the event list
     */
	public void print() {
		for (Event x : this.lst) {
			System.out.println(x);
		}
	}

    /**
     * Checks to see if the event is in the event list
     *
     * @return boolean indicating if event is in the list 
     */
	public boolean elm(Event x) {
		for (Event y: this.lst) {
			if (x == y)
				return true;
		}
		return false;
	}
}
