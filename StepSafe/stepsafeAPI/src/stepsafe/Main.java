package stepsafe;

import java.io.IOException;

import types.CrmALst;
import types.Point2D;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//create a CrmALst instance:
		CrmALst dbase = new CrmALst();
		//apply fuhttps://marketplace.eclipse.org/content/eclipse-java-ee-developer-tools-0nction to load data to dbase:
		ReadFile.read_from_db(dbase);
		//dbase.next();
		System.out.println(dbase.current().toString());
		
		Point2D start = dbase.current().getPoint2D();
		Point2D end = dbase.next().getPoint2D();
		
		Point2D mid = new Point2D((end.x()+ start.x())/2,(end.y()+start.y())/2);
		double radius = mid.distanceTo(start)*4;
		
	}
}
