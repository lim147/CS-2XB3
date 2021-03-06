package tests;

/**
 *  The {@code Test tests}
 *  Dependencies: 
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 */
import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import stepsafe.Client;
import stepsafe.ReadFile;
import types.Event;
import types.Point2D;
import types.Path;
import types.Intersection;

public class TestRead {

	ArrayList<Event> dbase;
	Event crime1;
	Event crime2;
	Event crime3;
	Event crime4;
	Event crime5;
	
	@Before
	public void setUp() throws Exception {
		
		dbase = new ArrayList<Event>();
		crime1 = new Event("1", 2019, "Jan", 1, 12, "Description", new Point2D(0,0),2.0);
		crime2 = new Event("2", 2018, "March", 2, 18, "Description", new Point2D(1,0),3.0);
		crime3 = new Event("3", 2019, "August", 3, 2, "Description", new Point2D(43,49),4.0);
		crime4 = new Event("4", 2016, "April", 15, 8, "Description", new Point2D(0,3),2.0);
		
		dbase.add(crime1);
		dbase.add(crime2);
		dbase.add(crime3);
		dbase.add(crime4);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws NumberFormatException, IOException {
		testFilter();
		testPath();
	}
	
	public void testEvent(){
		Event crime1 = new Event("1", 1, "Jan", 1, 1, "Description", new Point2D(0,0),2.0);
		Event crime2 = new Event("2", 2, "Jan", 2, 2, "Description", new Point2D(1,0),2.0);

		System.out.println(crime2.toString());		
	}
	
	//Test for filter to see if it filters as required
	public void testFilter() {		
		Point2D start = new Point2D (-3,0); 
		Point2D end = new Point2D (3,0); 
		
		Point2D mid = new Point2D((end.getX()+ start.getX())/2,(end.getY()+start.getY())/2);
		double radius = mid.distanceTo(start)*4;
		
		ArrayList<Event> fList = Client.filterCrimes (dbase, mid, radius);
		
		assert(fList.contains(crime1) == true);
		assert(fList.contains(crime2) == true);
		assert(fList.contains(crime3) == false);
		assert(fList.contains(crime4) == true);
	}
	
	//Test for optimalPath to see if it gets the correct path
	public void testPath() throws NumberFormatException, IOException{
		Intersection start = new Intersection(0,0,"Start here");
		Intersection end = new Intersection(0,0,"End here");
		
		Intersection i1 = new Intersection(0,2,"turn right");
		Intersection i2 = new Intersection(4,2,"turn right");
		Path path1 = new Path();
		path1.addIntersection(start);
		path1.addIntersection(i1);
		path1.addIntersection(i2);
		path1.addIntersection(end);
		
		Intersection i3 = new Intersection(2,0,"turn right");
		Intersection i4 = new Intersection(2,4,"turn right");
		Path path2 = new Path();
		path2.addIntersection(start);
		path2.addIntersection(i3);
		path2.addIntersection(i4);
		path2.addIntersection(end);
		
		Intersection i5 = new Intersection(2,0,"turn right");
		Intersection i6 = new Intersection(4,0,"turn right");
		Intersection i7 = new Intersection(4,2,"turn right");
		Path path3 = new Path();
		path3.addIntersection(start);
		path3.addIntersection(i5);
		path3.addIntersection(i6);
		path3.addIntersection(i7);
		path3.addIntersection(end);
		
		ArrayList<Path> pathL = new ArrayList<Path>();
		pathL.add(path1);
		pathL.add(path2);
		pathL.add(path3);
		
		ArrayList<Event> dbase2 = new ArrayList<Event>();
		crime1 = new Event("1", 2019, "Jan", 1, 12, "Description", new Point2D(1,1),1.0);
		crime2 = new Event("2", 2018, "March", 2, 18, "Description", new Point2D(0,3),1.0);
		crime3 = new Event("3", 2019, "August", 3, 2, "Description", new Point2D(1,3),1.0);
		crime4 = new Event("4", 2016, "April", 15, 8, "Description", new Point2D(1,4),1.0);
		crime5 = new Event("5", 2016, "April", 15, 8, "Description", new Point2D(2,3),1.0);
		
		dbase2.add(crime1);
		dbase2.add(crime2);
		dbase2.add(crime3);
		dbase2.add(crime4);
		dbase2.add(crime5);
		
		Path testPath = Client.optimalPath(pathL,dbase2);
		System.out.println(testPath);
	}
}
