package types;

import java.util.ArrayList;
import java.util.List;

/**
 *  The {@code CrmALst} class is an object that holds the list of Crime Events relevant to user input
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

public class CrmALst {
	private int i; //counter
	private List<Event> lst;
	
    /**
     * Constructor for a list of Crime events
     *
     * 
     */
	public CrmALst() {
		this.i = 0;
		this.lst = new ArrayList<Event>();
		
	}
	
	
    /**
     * Mutator where a crime event is added to the list
     *
     * @param  e the event being added
     * 
     */
	public void addEvent(Event e) {
		lst.add(e);
	}
	
	//mutator: go to the start
	public void start() {
		i = 0;
	}
	
	//accessor: return the current event
	public Event current() {
		return lst.get(i);
	}
	
	//accessor&mutator: return the next Event
	public Event next() {
		i++;
		return lst.get(i-1);
	}
	
	public boolean end() {
		if (i == lst.size())
			return true;
		else
			return false;
	}
	
	
	
	
}
