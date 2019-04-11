package types;

import java.util.ArrayList;

/**
 *  The {@code Intersection} class represents a ADT for an Intersection at some coordinate location
 *  Dependencies: Point2D.java
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  @version 1.0
 *  @since 2019-04-03
 */

public class Intersection {
	private int id;
	private final Point2D location;
	private double crimeDst; 
	private String instruction;
	private ArrayList<Event> crmLst;
	
    /**
     * Constructor for an intersection that takes Name, and coordinates as two doubles
     *
     * @param  Name the name of the intersection
     * @param  x the longitude
     * @param  y the latitude
     */
	public Intersection(double x, double y, String instruction) {
		this.location = new Point2D(x,y);
		this.instruction = instruction;
		crmLst = new ArrayList<Event>();
	}
	
    /**
     * Sets the crimeDst value
     *
     * @param  value is the crime rating value
     */
	public void setCrimeDst(double value) {
		crimeDst = value;
	}
	
    /**
     * Gets the crimeDst value
     *
     *@return the crime rating value
     */
	public double getCrimeDst() {
		return crimeDst;
	}
	
    /**
     * Sets the id value
     *
     * @param  id value of intersection
     */
	public void setId(int value) {
		id = value;
	}
	
    /**
     * Gets the id value
     *
     * @return  id value of intersection
     */
	public int getId() {
		return id;
	}
	   
    /**
     * Accesses the location value
     *
     * @return the name of the intersection
     */
	public Point2D getLocation() {
		return location;
	}
	
    /**
     * Accesses the instruction
     *
     * @return the instruction at the intersection
     */
	public String getInstruction() {
		return instruction;
	}
	
    /**
     * Adds a Crime Event to the Crime Event list
     *
     *@param e the crime event to be added to the list
     */
	public void addCrm(Event e) {
		crmLst.add(e);
	}
	
    /**
     * Prints out the Intersection in a string format
     *
     * @return intersection in a string format
     */
	public String toString() {
		String s = location.toString() + " " + instruction;
		return s;
	}
	
    /**
     * Prints out the Intersection in a string format for the web
     *
     * @return intersection in a string format for the web
     */
	public String toWeb() {
		String s = instruction;
		return s;
	}
}
