package types;

/**
 *  The {@code Point2D} class holds a data type for a 2D Point/Coordinate
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

import java.awt.Point;

public class Point2D {
	
	private final double x;
	private final double y;
	
    /**
     * Constructor for Point2D that holds coordinates of a location
     *
     * @param  Id the Id of the path
     * @param  Inter a list of Point2D
     */
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
    /**
     * Accessor for x
     * @return x
     */
	public double x() {return x;}
	
    /**
     * Accessor for y
     * @return y
     */
	public double y() {return y;}
	
    /**
     * Accessor for x
     * @param that the  Point2D whose distance to is to be calculated
     * @return double representing the distance between current object and "that"
     * https://www.movable-type.co.uk/scripts/latlong.html
     */
	public double distanceTo(Point2D that) {
		int R = 6371; //km
		double x1 = Math.toRadians(this.x);
		double x2 = Math.toRadians(that.x);
		double dlat= Math.toRadians(this.x - that.x);
		double dlng = Math.toRadians(this.y - that.y);
		
		double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(x1) * Math.cos(x2)*Math.pow(Math.sin(dlng/2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dis = R * c;
		return dis;
	}
	
    /**
     * Returns the Point2D as a string
     * @return the Point2D as a string
     */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
