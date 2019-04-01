package stepsafe;

import java.io.IOException;
import types.Point2D;
import types.Event;

/**
 *  The {@code Client class interfaces with various classes as well as web application and Google Maps API
 *  Dependencies: Point2D.java
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 */

public class Client {

	public static Point2D start;
	public static Point2D end;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//create a CrmALst instance:
		CrmALst dbase = new CrmALst();
		//apply fuhttps://marketplace.eclipse.org/content/eclipse-java-ee-developer-tools-0nction to load data to dbase:
		ReadFile.read_from_db(dbase);
		//dbase.next();
		System.out.println(dbase.current().toString());
		
		Point2D mid = new Point2D((end.x()+ start.x())/2,(end.y()+start.y())/2);
		CrmALst cList = new CrmALst();
		cList.start();
		
		// Go through dbase and get relevant crimes within a radius of the area being searched
		
		//1 mile =1.609 kilometers
		//1 degree of longitude = ~55.2428 miles = ~88.8856652 kilometers based in Saratoga, California
		//1 kilometer =~0.01125040801 degrees
		double radius = mid.distanceTo(start)*4;
		while (cList.end() == false) {
			Event tEvent = cList.next();
			if (mid.distanceTo(tEvent.getPoint2D()) < radius) {
				cList.addEvent(tEvent);
			}
		}	
		
	}
	
	
	
	public double count(Point2D point) {
		return 0;
	}
	
	
}
