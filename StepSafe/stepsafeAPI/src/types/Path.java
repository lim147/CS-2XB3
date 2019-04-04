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
 *  @version 1.0
 *  @since 2019-04-03
 */
public class Path {
	
	private final int Id;
	private ArrayList<Intersection> Inter;
	private double rating;
	
    /**
     * Constructor for an intersection that takes Name, and list of intersection
     *
     * @param  Id the Id of the path
     * @param  Inter a list of Point2D
     */
	public Path(int Id) {
		this.Id = Id;
		this.Inter = new ArrayList<Intersection>();
	}
	
    /**
     * Accessor for the array of intersections
     */
	public ArrayList<Intersection> getInter(){
		return Inter;
	}
	
    /**
     * Accessor for the id of the path
     */
	public  int getId(){
		return Id;
	}
	
	public int size() {
		return Inter.size();
	}
	
}
