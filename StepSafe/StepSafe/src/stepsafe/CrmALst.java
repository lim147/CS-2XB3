package stepsafe;

import java.util.ArrayList;
import java.util.List;

public class CrmALst {
	private int i; //counter
	private List<Event> lst;
	
	//constructor
	public CrmALst() {
		this.i = 0;
		this.lst = new ArrayList<Event>();
		
	}
	
	
	//mutator: add the event to the array
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
	
	
	
	
}
