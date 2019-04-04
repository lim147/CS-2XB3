package stepsafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import types.Point2D;
import types.CrmALst;
import types.Event;
import types.Path;
import types.Intersection;

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

	public Point2D start;
	public Point2D end;
	
	//add constructor:
	public Client(Point2D s, Point2D e) {
		start = s;
		end = e;
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
	public static List<Event> filterCrimes (List<Event> oList, Point2D origin , double r) {
		List<Event> cList = new ArrayList<Event>();
		
		for (int i = 0; i < oList.size(); i++) {
			Event tEvent = oList.get(i);
			if (inRadius(origin, tEvent.getPoint2D(),r))
				cList.add(tEvent);
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
     */
	public static boolean inRadius(Point2D origin, Point2D target, double r) {
		if (origin.distanceTo(target) < r)
			return true;
		else
			return false;
	}
	
    /**
     * Assigns crime ratings to intersections in paths
     *
     * @param  list of paths
     */	
	/**
	public static List<Path> optimalPath(List<Path> pathlist, List<Event> oList){

		for (Path p : pathlist) {
			List<Intersection> interList = p.getInter();
			for (int i = 0; i < p.getInter().size();i++) {
				for (Event e : oList) {
					
				}
			}
		}
	}**/
	
	public double count(Point2D point) {
		return 0;
	}
	
	
	
}
