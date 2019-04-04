package stepsafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.LinearProbingHashST;
import edu.princeton.cs.algs4.Digraph;

import types.Point2D;
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
     * @param  pathlist list of paths
     * @param  oList list of relevant crime events
     * 
     */	
	
	public static void optimalPath(List<Path> pathlist, List<Event> oList, Intersection Start, Intersection End){
		
		System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		// Assign a value to each intersection and start and end
		//List<Integer> InterPath = new ArrayList<Integer>();
		//InterPath.add(0); // Start identifier
		//InterPath.add(1); // End identifier
		
		int interCount = 0; // Total number of intersections in all paths
		
		int interIndex = 2; // Intersection index
		double interDistTotal=0; // Accumulation of distance from crime events
		
		//Calculate the distance between intersection and crime event, add value to intersection object
		for (Path p : pathlist) { // For every path in the list
			List<Intersection> interList = p.getInter(); // get the intersection list from the path
			
			// skip the first and last intersections in the list
			for (int i = 1; i < p.getInter().size()-1;i++) { // Iterate through intersections in cur path
				
				Intersection inter = interList.get(i); // current intersection in list
				System.out.println(inter);
				
				for (Event e : oList) {
					Event copy = new Event(e); // Create a copy of the event
					copy.distanceTo(inter.getLocation()); // Calculate and store distance from intersection
					inter.addCrm(e); // add crime to intersection list
					interDistTotal+= copy.getdistTo();
				}

				inter.setCrimeDst(interDistTotal); // Set the intersection crime distance value
				inter.setId(interIndex); // Set intersection id to id
				
				//InterPath.add(p.getId()); // For each intersection, the id is the path it is in
				interIndex+=1;
				interDistTotal=0; // reset the intersection distance accumulator
				interCount+=1; // Total number of intersections 
			}
		}
		
		//Edge weighted intersection graph
		EdgeWeightedDigraph interGraph = new EdgeWeightedDigraph(interCount);
		

		//Connect the paths
		for (Path p : pathlist) { // For every path in the list
			List<Intersection> interList = p.getInter(); // get the intersection list from the path
			
			//Connect start and first intersection
			interGraph.addEdge(new DirectedEdge(0,interList.get(0).getId(),0));
			 
			for (int i = 1; i < p.getInter().size()-1;i++) { // Iterate through intersections
				
				Intersection inter1 = interList.get(i); // current intersection in list
				Intersection inter2 = interList.get(i+1); // next intersection in list
				
				interGraph.addEdge(new DirectedEdge(inter1.getId(), inter2.getId(), inter1.getCrimeDst()));
			}
			//Connect last intersection and end
			Intersection last = interList.get(interList.size()-2); 
			interGraph.addEdge(new DirectedEdge(last.getId(),1,last.getCrimeDst()));
		}
		
		// Call Dijkstra's algorithm to get cost-effective path

		DijkstraSP sPath = new DijkstraSP(interGraph,0);
		Iterable<DirectedEdge> sonePath = sPath.pathTo(1);
		
		// Print out cost-effective path
		for (DirectedEdge a : sonePath) {
			System.out.print(a);
		}
		
	}

	
	
}
