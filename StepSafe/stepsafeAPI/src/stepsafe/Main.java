package stepsafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import types.CrmALst;
import types.Event;
import types.Point2D;
import types.Path;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//create a CrmALst instance:

		List<Event> dbase = new ArrayList<Event>();
		//Merge.sortMergeTD(dbase, dbase.size());
	
		
		//apply fuhttps://marketplace.eclipse.org/content/eclipse-java-ee-developer-tools-0nction to load data to dbase:
		ReadFile.read_from_db(dbase);
		//dbase.next();

		
		Point2D start = new Point2D (0,0); // get this from Rob
		Point2D end = new Point2D (); // get this from Rob
		
		Point2D mid = new Point2D((end.x()+ start.x())/2,(end.y()+start.y())/2);
		double radius = mid.distanceTo(start)*4;
		
		List<Event> fList = Client.filterCrimes (dbase, mid, radius);
		
		// list of paths
		List<Path> Plst = new ArrayList<Path>(); // get this from Rob
		
		
		
	}
}
