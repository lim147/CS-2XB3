/**
 * 
 */
package tests;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import stepsafe.QuickSort;
import types.Event;
import types.Point2D;

/**
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *
 */
public class TestSort {

	int nodes = 4;
	Event crime1;
	Event crime2;
	Event crime3;
	Event crime4;
	Event crime5;
	Event[] list;
	Event[] list2;
			
	
	
	
	@Before
	public void setUp() throws Exception {
		
		crime1 = new Event("1", 2019, "Jan", 1, 12, "Description", new Point2D(0,0),2.0);
		crime2 = new Event("2", 2018, "March", 2, 18, "Description", new Point2D(1,0),3.0);
		crime3 = new Event("3", 2019, "August", 3, 2, "Description", new Point2D(43,49),4.0);
		crime4 = new Event("4", 2016, "April", 15, 8, "Description", new Point2D(0,3),2.0);
		list = new Event[nodes];
		list[0] = crime1;
		list[1] = crime2;
		list[2] = crime3;
		list[3] = crime4;
		
		crime5 = new Event("5",2019,"Test",15,8,"TestDescrip",new Point2D(0,2),2.0);
		list2 = new Event[3];
		list2[0] = crime1;
		list2[1] = crime5;
		list2[2] = crime4;
		
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testSort() throws Exception{
		
		QuickSort.sort(list);
		QuickSort.sort(list2);
		
	}
	


	

}
