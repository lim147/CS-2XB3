package types;

/**
 *  The {@code Event} class is an Abstract Data Type for Crime Events
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

import java.io.IOException;

public class Event implements Comparable<Event>{
//	Attributes
	
	private final String Id;
	private final int Year;
	private final String Month;
	private final int Day;
	private final int Hour;
	private final String MCI;
	private double distTo;
	private final Point2D Coord;
	
//	Constructor
	public Event(String Id, int Year, String Month, int Day, int Hour, String MCI, Point2D Coord) {
		this.Id = Id;
		this.Year = Year;
		this.Month = Month;
		this.Day = Day;
		this.Hour = Hour;
		this.MCI = MCI;
		this.Coord = Coord;

	}
	
	private void distanceTo(Event x) {
		double xdist = (this.Coord.x() - x.Coord.x());
		double ydist = (this.Coord.y() - x.Coord.y());
		this.distTo = Math.sqrt(Math.pow(xdist, 2) + Math.pow(ydist, 2));
	}
	
//	Compares the distTo values of two events
//	The "Greater" value has the smaller distance
	@Override
	public int compareTo(Event x) {
		if (this.distTo > x.distTo) return -1;
		if (this.distTo < x.distTo) return 1;
		else                        return 0;
	}
	
	public String getId() {
		return this.Id;
		}

	public int getYear() {
		return this.Year;
		}

	public String getMonth() {
		return this.Month;
		}
	
	public int getDay() {
		return this.Day;
	}

	public int getHour() {
		return this.Hour;
	}
	
	public String getMCI() {
		return this.MCI;
	}
	
	public double getCoordx() {
		return this.Coord.x();
	}
	
	public double getCoordy() {
		return this.Coord.y();
	}
	
	public Point2D getPoint2D() {
		return this.Coord;
	}
	
	public String toString() {
		return String.format("%s, %s %d %d : %d, %s, %s",Id, Month, Day, Year, Hour, MCI, Coord);
	}
	
	public static void main(String[] args) throws IOException {
		Event rob = new Event("1", 1, "Jan", 1, 1, "Hello", new Point2D(0,0));
		Event zach = new Event("2", 2, "Jan", 2, 2, "Hello", new Point2D(1,0));
		System.out.println(rob.getDay());
		System.out.println(rob.distTo);
		System.out.println(rob.toString());
		
		
	}
}