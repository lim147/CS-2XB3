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

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import types.Event;
import types.Point2D;

public class TestRead {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		//fail("Not yet implemented");
	}
	
	public void testEvent(){
		Event rob = new Event("1", 1, "Jan", 1, 1, "Hello", new Point2D(0,0));
		Event zach = new Event("2", 2, "Jan", 2, 2, "Hello", new Point2D(1,0));
		System.out.println(rob.getDay());
		System.out.println(rob.toString());		
	}
	


}
