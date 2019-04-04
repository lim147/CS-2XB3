package stepsafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.LinearProbingHashST;
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
	
	public static void optimalPath(List<Path> pathlist, List<Event> oList){
		
		// Assign a value to each crime event
		LinearProbingHashST<String,Integer> crimeId = new LinearProbingHashST<String,Integer>();
		String[] crimeName = new String[oList.size()];
		
		int interCount = 0; // Total number of intersections in all paths
		int interIndex = 0; // Intersection index
		double interDistTotal=0; // Accumulation of distance from crime events
		
		Intersection start = pathlist.get(0).getInter().get(0); // Start node
		start.setId(interIndex); // Index of start node is 0
		interIndex+=1;
		
		Intersection end = pathlist.get(0).getInter().get(-1); // End node //CHECK
		
		for (Path p : pathlist) { // For every path in the list
			List<Intersection> interList = p.getInter(); // get the intersection list from the path
			for (int i = 0; i < p.getInter().size();i++) { // Iterate through intersections
				
				Intersection inter = interList.get(i); // Intersection in list
				
				
				for (Event e : oList) {
					Event copy = new Event(e); // Create a copy of the event
					copy.distanceTo(inter.getLocation()); // Calculate and store distance from intersection
					inter.addCrm(e); // add crime to intersection list
					interDistTotal+= copy.getdistTo();
				}
			inter.setCrimeDst(interDistTotal); // Set the intersection crime distance value
			interDistTotal=0; // reset the intersection distance accumulator
			interCount+=1;
			}
			interCount-=2; // subtract the beginning and end intersections, which will be added later
		}
		
		
		interCount+=2; // Add the beginning and end intersections to count
		//Edge weighted intersection graph
		EdgeWeightedDigraph interGraph = new EdgeWeightedDigraph(interCount);
	}
	
	public double count(Point2D point) {
		return 0;
	}
	
	
	
}
