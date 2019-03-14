package stepsafe;

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
	
	public double distanceTo(Point2D that) {
		double dx = this.x - that.x;
		double dy = this.y - that.y;
		return Math.sqrt(dx*dx + dy*dy);
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

	}

}
