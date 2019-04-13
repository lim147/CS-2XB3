package types;

/**
 *  The {@code Event} class is an Abstract Data Type for Crime Events
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

import java.io.IOException;

public class Event implements Comparable<Event>{
	
	private final String Id;
	private final int Year;
	private final String Month;
	private final int Day;
	private final int Hour;
	private final String MCI;
	private double distTo;
	private final Point2D Coord;
	private final double Degree;
	
   /**
    * Constructor of Event class 
    *
    * @param  Id the id of the event
    * @param  Year the year of the event
    * @param  Month the month of the event
    * @param  Day the day of the event 
    * @param  Hour the hour of the event 
    * @param  MCI the MCI of the event 
    * @param  Coord the coordinates of the point
    */
	public Event(String Id, int Year, String Month, int Day, int Hour, String MCI, Point2D Coord, Double Degree) {
		this.Id = Id;
		this.Year = Year;
		this.Month = Month;
		this.Day = Day;
		this.Hour = Hour;
		this.MCI = MCI;
		this.Coord = Coord;
		this.Degree = Degree;
	}
	
	/**
	 * Method that calculates the distance to an Event
	 * 
	 * @param x the event to calculate the distance to
	 */
	public void distanceTo(Point2D x) {
		double xdist = (this.Coord.getX() - x.getX());
		double ydist = (this.Coord.getY() - x.getY());
		this.distTo = Math.sqrt(Math.pow(xdist, 2) + Math.pow(ydist, 2));
		this.distTo*=this.Degree;
		this.distTo=1/(this.distTo);
	}
	
	/**
	 * Compares the distTo values of two events
	 * The "Greater" value has the smaller distance
	 * 
	 * @param  x the event to be compared to
	 */
	@Override
	public int compareTo(Event x) {
		if (this.distTo > x.distTo) return -1;
		if (this.distTo < x.distTo) return 1;
		else                        return 0;
	}

	/**
	 * Accessor for the Id
	 * 
	 * @return Id of the event
	 */
	public String getId() {
		return this.Id;
		}

	/**
	 * Accessor for the Point2D 
	 * 
	 * @return Point2D of the event
	 */
	public Point2D getPoint2D() {
		return this.Coord;
	}

	/**
	 * Accessor for the Degree of the crime
	 * 
	 * @return degree of the cime
	 */
	public double getDegree() {
		return this.Degree;
	}
	
	/**
	 * Accessor for the distance to a Point2D
	 * 
	 * @return distance to a Point2D
	 */
	public double getdistTo() {
		return this.distTo;
	}
	
	/**
	 * Prints out the Event as a string
	 * 
	 * @return String format of the Event
	 */
	public String toString() {
		return String.format("Id: %s, Date: %s %d %d : %d, MCI: %s, Coord: %s",Id, Month, Day, Year, Hour, MCI, Coord);
	}
}