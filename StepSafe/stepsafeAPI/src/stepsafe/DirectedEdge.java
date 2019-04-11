package stepsafe;

/**
 *  The {@code DirectedEdge} is a modified Directed Edge class taken from Algorithms Textbook by
 *  Robert Sedgewick and Kevin Wayne 
 *  This class represents a weighted edge in an {@link EdgeWeightedDigraph}. Each edge consists of two integers
 *  (naming the two vertices) and a real-value weight. The data type provides methods for accessing the two endpoints of the directed edge and
 *  the weight.
 *  @author Alice Ip
 *  @version 1.0
 *  @since 2019-04-03
 *  
 *  see <a href="https://algs4.cs.princeton.edu/44sp">Section 4.4</a> of    
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne. 
 */


public class DirectedEdge { 
    private final int v;
    private final int w;
    private final double weight;


    /**
     * Initializes a directed edge from vertex {@code v} to vertex {@code w} with
     * the given {@code f}.
     * @param v the tail vertex
     * @param w the head vertex
     * @param weight the weight of the edge
     * @throws IllegalArgumentException if either {@code v} or {@code w}
     *    is a negative integer
     * @throws IllegalArgumentException if {@code weight} is {@code NaN}
     */
    public DirectedEdge(int v, int w, double weight) {
        if (v < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");
        if (w < 0) throw new IllegalArgumentException("Vertex names must be nonnegative integers");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
        this.v = v;
        this.w = w;
        this.weight = weight; // sets the weight to be the price of the food
    }

    /**
     * Returns the tail vertex of the directed edge.
     * @return the tail vertex of the directed edge
     */
    public int from() {
        return v;
    }

    /**
     * Returns the head vertex of the directed edge.
     * @return the head vertex of the directed edge
     */
    public int to() {
        return w;
    }

    /**
     * Returns the weight of the directed edge.
     * @return the weight of the directed edge
     */
    public double weight() {
        return weight;
    }

    /**
     * Returns a string representation of the directed edge.
     * @return a string representation of the directed edge
     */
    public String toString() {
        return " " + v + "->" + w + " " + String.format("%5.2f", weight);
    }
}