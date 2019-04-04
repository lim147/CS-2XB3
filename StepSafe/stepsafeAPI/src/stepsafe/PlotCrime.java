package stepsafe;
import edu.princeton.cs.algs4.*;
import types.Event;
import types.Point2D;

/**
 *  The {@code PlotCrime} class holds types to store crime information
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 *  
 */

public class PlotCrime { //test
	
	public static void plot_route(Point2D start,Point2D end) {
		StdDraw.point(start.x(), start.y());
		StdDraw.point(end.x(), end.y());
	}
	
	public static void plot_crimes(Event[] al) {
		for(int i = 0;i < al.length;i++) {
			StdDraw.point(al[i].getCoordx(), al[i].getCoordy());
		}
	}
	
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(800, 800);
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(StdDraw.BLUE);
		Point2D s = new Point2D(0.4,0.4);
		Point2D e = new Point2D(0.8,0.8);
		Event rob = new Event("1", 1, "Jan", 1, 1, "Hello", new Point2D(0.5,0.5),2.0);
		Event zach = new Event("2", 2, "Jan", 2, 2, "Hello", new Point2D(0.6,0.6),3.0);
		Event[] list = new Event[2];
		list[0] = rob;
		list[1] = zach;
		StdDraw.setPenRadius(0.02);
		plot_crimes(list);
		
		StdDraw.setPenColor(StdDraw.RED);
		plot_route(s,e);

        
        
		//StdDraw.setXscale(-10, 100000);
		//StdDraw.setYscale(0, 100);
		//StdDraw.line(-100, 0, 100000, 0); // x-axis
		//StdDraw.line(0,0,0, 100); // y-axis
		//StdDraw.point(0.5,  0.5);
		
	}

}
