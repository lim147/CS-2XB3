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
	
	private ArrayList<Intersection> Inter;
	
    /**
     * Constructor for an intersection that takes Name, and list of intersection
     *
     * @param  Id the Id of the path
     * @param  Inter a list of Point2D
     */
	public Path() {
		this.Inter = new ArrayList();
	}
	
	//add intersection to the path
	public void addIntersection(Intersection e) {
		Inter.add(e);
	}
	
    /**
     * Accessor for the array of intersections
     */
	public ArrayList<Intersection> getInter(){
		return Inter;
	}
	
	
	public int size() {
		return Inter.size();
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < size(); i++)
			s += Inter.get(i) + "\n";
		return s;
	}
	
	public String toWeb() {
		String s = "";
		for (int i = 0; i < size(); i++)
			s += Inter.get(i).toWeb() + "<br/>";
		return s;
	}
	
}
