package stepsafe;
/**
 *  The {@code Quicksort} is a sorting algorithm
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  
 *  @version 1.0
 *  @since 2019-04-10
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import types.Event;
import types.Point2D;


public class QuickSort{

    // This class should not be instantiated.
    private QuickSort() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
     * @param a the array to be sorted
     */
    public static void sort(Event[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(Comparable[] a, int lo, int hi) { 
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
        assert isSorted(a, lo, hi);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while (true) { 

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == lo) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    /**
     * Rearranges the array so that {@code a[k]} contains the kth smallest key;
     * {@code a[0]} through {@code a[k-1]} are less than (or equal to) {@code a[k]}; and
     * {@code a[k+1]} through {@code a[n-1]} are greater than (or equal to) {@code a[k]}.
     *
     * @param  a the array
     * @param  k the rank of the key
     * @return the key of rank {@code k}
     * @throws IllegalArgumentException unless {@code 0 <= k < a.length}
     */
    public static Comparable select(Comparable[] a, int k) {
        if (k < 0 || k >= a.length) {
            throw new IllegalArgumentException("index is not between 0 and " + a.length + ": " + k);
        }
        StdRandom.shuffle(a);
        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int i = partition(a, lo, hi);
            if      (i > k) hi = i - 1;
            else if (i < k) lo = i + 1;
            else return a[i];
        }
        return a[lo];
    }



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/
    
    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }
        
    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    public static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Event[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them; 
     * and prints them to standard output in ascending order. 
     * Shuffles the array and then prints the strings again to
     * standard output, but this time, using the select method.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args)throws IOException {
    	int numberofnodes = 131033;
    	Event[] listOfEvents = new Event[numberofnodes];
    	BufferedReader us = new BufferedReader(new FileReader("Dataset/MCI_2014_to_2017.csv"));
		String citylist = us.readLine(); //skips first line
		int j = 0;
		while((citylist = us.readLine()) != null) {
			//store the crimes and the longitude, latitude and node number in the array
			//citylist = us.readLine();
			String[] b = citylist.split(",");
			float f1 = Float.parseFloat(b[12]);
			float f2 = Float.parseFloat(b[13]);
			Point2D point = new Point2D(f1,f2);
			listOfEvents[j] = new Event(b[0],Integer.parseInt(b[2]),b[3],Integer.parseInt(b[4]),Integer.parseInt(b[7]),b[8],point,0.1);
			j++;
		}
		us.close();
		
		//System.out.println(f1);
		//System.out.println(f2);
        Quick.sort(listOfEvents);
        show(listOfEvents);
        assert isSorted(listOfEvents);
        PrintWriter out = new PrintWriter("Dataset/SortedEvents.txt");
        for (int i = 0; i < listOfEvents.length; i++) {
            out.println(listOfEvents[i]);
        }
        
        // shuffle
        StdRandom.shuffle(listOfEvents);

        // display results again using select
        /*
        StdOut.println();
        for (int i = 0; i < listOfEvents.length; i++) {
            String ith = (String) Quick.select(listOfEvents, i);
            StdOut.println(ith);
        }
        */
    }

}