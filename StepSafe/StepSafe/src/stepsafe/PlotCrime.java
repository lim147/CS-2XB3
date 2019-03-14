package stepsafe;
import edu.princeton.cs.algs4.*;
/**
 *  The {@code FundamentalTypes} class holds types to store crime information
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

public class PlotCrime {
	
	public static void plot(Point2D start,Point2D end) {
		StdDraw.point(start.x(), start.y());
		StdDraw.point(end.x(), end.y());
	}
	public static void main(String[] args) {

        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        
        
		Point2D s = new Point2D(0.5,0.5);
		Point2D e = new Point2D(5,5);
		plot(s,e);

        
        
		//StdDraw.setXscale(-10, 100000);
		//StdDraw.setYscale(0, 100);
		//StdDraw.line(-100, 0, 100000, 0); // x-axis
		//StdDraw.line(0,0,0, 100); // y-axis
		//StdDraw.point(0.5,  0.5);
		
	}

}
