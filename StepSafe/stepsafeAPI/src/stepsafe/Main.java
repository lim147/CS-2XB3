package stepsafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import notused.CrmALst;
import types.Event;
import types.Point2D;
import types.Path;
import types.Intersection;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ArrayList<Event> dbase = new ArrayList<Event>(); //create a CrmALst instance:
		ReadFile.read_from_db(dbase);

		Intersection s = new Intersection(0,0,"start"); // get from Rob
		Intersection e = new Intersection(0,0,"end"); // get from rob
		Point2D mid = new Point2D((e.getLocation().x()+ s.getLocation().x())/2,(e.getLocation().y()+s.getLocation().y())/2);
		double radius = mid.distanceTo(s.getLocation())*4;
		
		ArrayList<Event> fList = Client.filterCrimes (dbase, mid, radius);
		
		// list of paths
		ArrayList<Path> Plst = new ArrayList<Path>(); // get this from Rob
		ArrayList<Intersection> Olst = Client.optimalPath(Plst,fList);
	}
}
