package stepsafe;

/**
 *  The {@code Point2D} class holds a data type for a 2D Point/Coordinate
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-13
 */

import java.awt.Point;

public class Point2D {
	
	private final double x;
	private final double y;
	
	public Point2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point2D() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public double x() {return x;}
	public double y() {return y;}
	public double r() {return Math.sqrt(x*x + y*y); }
	public double theta() {return Math.atan2(y,  x);}
	
	//calculate distance(km)
	public double distanceTo(Point2D that) {
		//https://www.movable-type.co.uk/scripts/latlong.html
		int R = 6371; //km
		double x1 = Math.toRadians(this.x);
		double x2 = Math.toRadians(that.x);
		double dlat= Math.toRadians(this.x - that.x);
		double dlng = Math.toRadians(this.y - that.y);
		
		double a = Math.pow(Math.sin(dlat/2), 2) + Math.cos(x1) * Math.cos(x2)*Math.pow(Math.sin(dlng/2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double dis = R * c;
		return dis;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public static void main(String[] args) {
		
		/**
		
		Point2D p = new Point2D();
		System.out.println("p = " + p);
		System.out.println(" x = " + p.x());
		System.out.println(" y = " + p.y());
		System.out.println(" r = " + p.r());
		System.out.println(" theta = " + p.theta());
		System.out.println();
		
		Point2D q = new Point2D(0.5, 0.5);
		System.out.println("q = " + q);
		System.out.println("dist(p, q) = " + p.distanceTo(q));
		
		Point2D a = new Point2D();
		System.out.println("a = " + a);
		
		Point2D b = new Point2D();
		System.out.println("b = " + b);
		System.out.println("dist(a,b) = " + a.distanceTo(b));
		
		**/
		Point2D p = new Point2D(43.7688293, -79.520401);
		Point2D q = new Point2D(43.7646408, -79.3446503);
		System.out.println("dist(p, q) = " + p.distanceTo(q));
		
		
	}

}
