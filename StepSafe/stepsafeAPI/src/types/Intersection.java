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
	private double crimeDst; // TODO: calls a function to find average crime distance
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
     * Constructor for an intersection that takes Name, and coordinates as Point2D
     *
     * @param  Name the name of the intersection
     * @param  coord a Point2D containing longitude and latitude accordingly
     */
	public Intersection(String Name, Point2D coord) {
		this.location = coord;
	}
	
    /**
     * Initializes a new Intersection that is a deep copy of specified Intersection
     *
     * @param  Name the name of the intersection
     * @param  coord a Point2D containing longitude and latitude accordingly
     */
	public Intersection(Intersection i) {
		this.location = i.getLocation();
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
	
	
	public String getInstruction() {
		return instruction;
	}
	
	
	public void addCrm(Event e) {
		crmLst.add(e);
	}
	
	public String toString() {
		String s = location.toString() + " " + instruction;
		return s;
	}
	
	

}
