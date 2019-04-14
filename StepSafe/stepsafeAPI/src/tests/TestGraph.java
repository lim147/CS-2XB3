/**
 * 
 */
package tests;

import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.algs4.In;
import types.DirectedEdge;
import types.EdgeWeightedDigraph;

/**
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *
 */
public class TestGraph {

	In in;
	EdgeWeightedDigraph graph;
	String s;
	DirectedEdge e;
	DirectedEdge f;
	
	@Before
	public void setUp() throws Exception {
		BufferedReader s = new BufferedReader(new FileReader("graphtest"));
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDigraph() {
		in = new In(s);
		graph = new EdgeWeightedDigraph(10);
		
	}
	public void testDirectedEdge() {
		e = new DirectedEdge(12, 34, 5.67);
		f = new DirectedEdge(1,2,8.4);
	}
	
	
}
