package types;

import java.util.List;

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
	private final String Name;
	private int id;
	private final Point2D location;
	private double crimeDst; // TODO: calls a function to find average crime distance
	private List<Event> crmLst;
	
    /**
     * Constructor for an intersection that takes Name, and coordinates as two doubles
     *
     * @param  Name the name of the intersection
     * @param  x the longitude
     * @param  y the latitude
     */
	public Intersection(String Name, double x, double y) {
		this.Name = Name;
		this.location = new Point2D(x,y);
	}

    /**
     * Constructor for an intersection that takes Name, and coordinates as Point2D
     *
     * @param  Name the name of the intersection
     * @param  coord a Point2D containing longitude and latitude accordingly
     */
	public Intersection(String Name, Point2D coord) {
		this.Name = Name;
		this.location = coord;
	}
	
    /**
     * Initializes a new Intersection that is a deep copy of specified Intersection
     *
     * @param  Name the name of the intersection
     * @param  coord a Point2D containing longitude and latitude accordingly
     */
	public Intersection(Intersection i) {
		this.Name = i.getName();
		this.location = i.getLocation();
	}

    /**
     * Sets the crimeDst value
     *
     * @param  value is the crime Dst value calculated
     */
	public void setCrimeDst(double value) {
		crimeDst = value;
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
     * Accesses the name value
     *
     * @return the name of the intersection
     */
	public String getName() {
		return Name;
	}
	
    /**
     * Accesses the location value
     *
     * @return the name of the intersection
     */
	public Point2D getLocation() {
		return location;
	}

	public void addCrm(Event e) {
		crmLst.add(e);
	}
	

}
