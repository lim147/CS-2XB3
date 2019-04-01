package types;

import java.util.ArrayList;
import java.util.List;

/**
 *  The {@code Path} class represents a ADT for an Path
 *  Dependencies: Point2D.java
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 */
public class Path {
	private final String Name;
	private List<Point2D> Inter;
	private double rating;
	
    /**
     * Constructor for an intersection that takes Name, and list of intersection
     *
     * @param  Name the name of the intersection
     * @param  Inter a list of Point2D
     * 
     */
	public Path(String Name, double Inter) {
		this.Name = Name;
		this.Inter = new ArrayList<Point2D>();
	}
}
