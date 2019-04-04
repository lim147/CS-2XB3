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
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import notused.CrmALst;
import stepsafe.Client;
import types.Event;
import types.Point2D;
import types.Path;
import types.Intersection;

public class TestRead {

	List<Event> dbase;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
		//testFilter();
	}
	
	public void testEvent(){
		Event crime1 = new Event("1", 1, "Jan", 1, 1, "Description", new Point2D(0,0),2.0);
		Event crime2 = new Event("2", 2, "Jan", 2, 2, "Description", new Point2D(1,0),2.0);
		System.out.println(crime1.getDay());
		System.out.println(crime2.toString());		
	}
	
	public void testFilter() {		

		dbase = new ArrayList<Event>();
		Event crime1 = new Event("1", 2019, "Jan", 1, 12, "Description", new Point2D(0,0),2.0);
		Event crime2 = new Event("2", 2018, "March", 2, 18, "Description", new Point2D(1,0),3.0);
		Event crime3 = new Event("3", 2019, "August", 3, 2, "Description", new Point2D(43,49),4.0);
		Event crime4 = new Event("4", 2016, "April", 15, 8, "Description", new Point2D(0,3),2.0);
		
		dbase.add(crime1);
		dbase.add(crime2);
		dbase.add(crime3);
		dbase.add(crime4);
		
		Point2D start = new Point2D (-3,0); 
		Point2D end = new Point2D (3,0); 
		
		Point2D mid = new Point2D((end.x()+ start.x())/2,(end.y()+start.y())/2);
		double radius = mid.distanceTo(start)*4;
		
		List<Event> fList = Client.filterCrimes (dbase, mid, radius);
		//fList.print();
		
		assert(fList.contains(crime1) == true);
		assert(fList.contains(crime2) == true);
		assert(fList.contains(crime3) == false);
		assert(fList.contains(crime4) == true);
	}
	
	public void testPath(){
		Intersection start = new Intersection("Start",0,0,"Start here");
		Intersection end = new Intersection("End",0,0,"End here");
		
		Intersection i1 = new Intersection("i1",)
		Path path1 = new Path(1);
		Path path2 = new Path(2);
		Path path3 = new Path(3);
		
		//List<Path> testPathList = new ArrayList<Path>();
		//testPathList.add();
		
	}
}
