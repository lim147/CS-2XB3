package stepsafe;

/**
 *  The {@code Client} class Class provides functionalities generate paths as well as select the optimal path 
 *  considering both distances and crime rates.
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @authorIndika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 *  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import types.*;

public class Client {	
	
	public Point2D start;
	public Point2D end;
	
	 /**
     * generatePaths sends requests to Google API and generate paths based on intersections data google returns.
     * Note: the path for python script has to be full pathname to make sure that jsp file could find it in web running environment.
     * 
     * @param  CrmAList the original crime list
     * @param  origin point to filter around
     * @param  r radius of the circle around target for filtering
     * @return a new filtered CrmAList
     * 
     */
	public static ArrayList<Path> generatePaths(String s, String t) throws IOException, InterruptedException {
		String cmd = "/Library/Frameworks/Python.framework/Versions/3.6/bin/python3";
		
		//The full path of hello_world.py, use pwd to get it.
		String filepath = "/Users/mc/Desktop/CS_2XB3/2XB3_Project/StepSafe/stepsafeAPI/py_scripts/hello_world.py";
		 
		/*
		 Alice:
		 
		 String cmd = "python";
		 String filepath = "C:\\Users\\Pieci\\Desktop\\Other\\2XB3_Project\\StepSafe\\stepsafeAPI\\py_scripts\\hello_world.py";
		 ...; -- The full path of hello_world.py, use pwd to get it.
		 */
		
		/*
		 Rob:
		 
		 String cmd = "python";
		 String filepath = "C:\\Users\\robbi\\Desktop\\Classes\\2XB3\\2XB3_Project\\StepSafe\\stepsafeAPI\\py_scripts\\hello_world.py"
		 */
		
		
		/*
		 May:
		 
		 String cmd = "/Library/Frameworks/Python.framework/Versions/3.6/bin/python3";
		 String filepath = "/Users/mc/Desktop/CS_2XB3/2XB3_Project/StepSafe/stepsafeAPI/py_scripts/hello_world.py";
		 */
		
		Process p = Runtime.getRuntime().exec(
				 cmd + " " + filepath + " " + s.replace(" ", "+") + " " + t.replace(" ", "+"));
		p.waitFor();
		
		ArrayList<Path> result = new ArrayList();
		Path route  = new Path();
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
			String line;
			while ((line = br.readLine()) != null) {
				if (line.equals("new path")) {
					result.add(route); //add the route to result list
					route = new Path(); //reinitialize the route
					System.out.println(line);
				}
				
				else {
					String [] holder = line.split(",");
					double x = Double.parseDouble(holder[0]);
					double y = Double.parseDouble(holder[1]);
					String str = holder[2];
					Intersection e = new Intersection(x, y, str); //create new intersection
					route.addIntersection(e);
				}
			}
		}		
		return result;
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
	public static ArrayList<Event> filterCrimes (ArrayList<Event> oList, Point2D origin , double r) {
		ArrayList<Event> cList = new ArrayList<Event>();
		
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
     * @throws IOException 
     * @throws NumberFormatException 
     * 
     */	
	public static Path optimalPath(ArrayList<Path> pathlist, ArrayList<Event> dbase) throws NumberFormatException, IOException{
		
		Intersection Start = (pathlist.get(0).getInter().get(0));
		int size = pathlist.get(0).getInter().size();
		Intersection End = (pathlist.get(0).getInter().get(size-1));
		
		Point2D mid = new Point2D((End.getLocation().getX()+ Start.getLocation().getX())/2,(End.getLocation().getY()+Start.getLocation().getY())/2);
		double radius = mid.distanceTo(Start.getLocation())*4;
		ArrayList<Event> fList = filterCrimes(dbase, mid, radius); // filter the crime database
		
		// Assign a value to each intersection and start and end
		ArrayList<Intersection> InterPath = new ArrayList<Intersection>();
		
		Start.setId(0);
		End.setId(1);
		InterPath.add(Start); // Start identifier
		InterPath.add(End); // End identifier
		
		int interCount = 2; // Total number of intersections in all paths
		int interIndex = 2; // Intersection index
		double interDistTotal=0; // Accumulation of distance from crime events
		
		//Calculate the distance between intersection and crime event, add value to intersection object
		for (Path p : pathlist) { // For every path in the list
			List<Intersection> interList = p.getInter(); // get the intersection list from the path
			
			// skip the first and last intersections in the list
			for (int i = 1; i < p.getInter().size()-1;i++) { // Iterate through intersections in cur path
				
				Intersection inter = interList.get(i); // current intersection in list
				
				for (Event ev : fList) {
					ev.distanceTo(inter.getLocation());
					inter.addCrm(ev); // add crime to intersection list
					interDistTotal+=ev.getdistTo();
				}

				inter.setCrimeDst(interDistTotal); // Set the intersection crime distance value
				inter.setId(interIndex); // Set intersection id to id
				InterPath.add(inter.getId(),inter); // For each intersection, the id is the path it is in
				interIndex+=1;
				interDistTotal=0; // reset the intersection distance accumulator
				interCount+=1; // Total number of intersections 
			}
		}
		
		//Edge weighted intersection graph
		EdgeWeightedDigraph interGraph = new EdgeWeightedDigraph(interCount);
		
		//Connect the paths
		for (Path p : pathlist) { // For every path in the list
			ArrayList<Intersection> interList = p.getInter(); // get the intersection list from the path
			
			//System.out.println(interList.size());
			
			//Connect start and first intersection
			DirectedEdge e1 = new DirectedEdge(0,interList.get(1).getId(),0);
			//System.out.println(e1);
			interGraph.addEdge(e1);
			 
			for (int i = 1; i < p.getInter().size()-2;i++) { // Iterate through intersections
				
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
		
		// Add intersections  in the optimal list to an intersection array list
		
		Path optPath = new Path();
		optPath.addIntersection(Start);
		for (DirectedEdge a : sonePath) {
			optPath.addIntersection(InterPath.get(a.to()));
		}
		return optPath;
	}
}