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
	private CrmALst crimeLst;
	
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
     * Sets the crimeDst value
     *
     * @param  value is the crime Dst value calculated
     */
	public void setCrimeDst(double value) {
		crimeDst = value;
	}
}
