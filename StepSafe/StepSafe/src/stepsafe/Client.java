package stepsafe;

import java.io.IOException;
import types.Point2D;
import types.CrmALst;
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
		double radius = mid.distanceTo(start)*4;
		
	}

    /**
     * Filters through a list of crimes, and returns a list where the crimes fall under the radius of a target Point2D
     * 1 mile =1.609 kilometers
     * 1 degree of longitude = ~55.2428 miles = ~88.8856652 kilometers based in Saratoga, California
     * 1 kilometer =~0.01125040801 degrees
     *
     * @param  CrmAList the original crime list
     * @param  origin point to filter around
     * @param  r radius of the circle around target for filtering
     * @return a new filtered CrmAList
     * 
     */
	public CrmALst filterCrimes (CrmALst oList, Point2D origin , double r) {
		CrmALst cList = new CrmALst();
		oList.start();
		
		while (oList.end() == false) {
			Event tEvent = oList.next();
			if (inRadius(origin, tEvent.getPoint2D(),r))
				cList.addEvent(tEvent);
		}
		return cList;
		
	}

    /**
     * Returns a boolean indicating if a point lies inside the circle created by origin and radius r
     *
     * @param  origin first Point2D
     * @param  target second Point2D
     * @param  r radius to check target under
     * @return boolean indicating whether target is under circle
     * 
     */
	public boolean inRadius(Point2D origin, Point2D target, double r) {
		if (origin.distanceTo(target) < r)
			return true;
		else
			return false;
	}
	
	public double count(Point2D point) {
		return 0;
	}
	
	
}
