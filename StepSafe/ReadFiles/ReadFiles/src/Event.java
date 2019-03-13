
public class Event implements Comparable<Event>{
//	Attributes
	
	private final String Id;
	private final int Year;
	private final String Month;
	private final int Day;
	private final int Hour;
	private final String MCI;
	private final double Lat;
	private final double Long;
	private double distTo;
	
//	Constructor
	public Event(String Id, int Year, String Month, int Day, int Hour, String MCI, double Lat, double Long) {
		this.Id = Id;
		this.Year = Year;
		this.Month = Month;
		this.Day = Day;
		this.Hour = Hour;
		this.MCI = MCI;
		this.Lat = Lat;
		this.Long = Long;
	}
	
	private void distanceTo(Event x) {
		double xdist = (this.Long + x.Long);
		double ydist = (this.Lat + x.Lat);
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
	

}
