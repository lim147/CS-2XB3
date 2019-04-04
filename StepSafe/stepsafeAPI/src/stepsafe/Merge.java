package stepsafe;

/**
 *  The {@code Merge} class performs Bottom-up and Top-down merges as necessary
 *  Reference: Algorithms Fourth Edition, Robert Sedgewick and Kevin Wayne
 *  @author Alice Ip
 *  @version 1.0
 *  @since 2019-02-22
 */
public class Merge {
	
	/**
	 * Checks to see if one comparable object is less than the other comparable object
	 * @param v - object of comparable type
	 * @param w - object of comparable type
	 * @return boolean result after comparing the two objects
	 */
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	/**
	 * Exchanges two objects in the array of Comparable type
	 * @param a - array of Comparable type
	 * @param i - index of first object to be exchanged
	 * @param j - index of second object to be exchanged
	 */
	private static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * Merges two arrays, using indexes given by calling function
	 * @param a - array of Comparable type
	 * @param aux - array of Comparable type
	 * @param lo - index of first item in subarray
	 * @param mid - index of mid item in subarray
	 * @param hi - index of last item in subarray
	 */
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if      (i > mid)            a[k] = aux[j++]; // if all the lower values have been appended
			else if (j > hi)             a[k] = aux[i++]; // if all the upper values have been appended
			else if (less(aux[j], aux[i]))   a[k] = aux[j++]; // if value at j is smaller, append j
			else                         a[k] = aux[i++]; // otherwise value at i is smaller, so append i
		}
	}
	
	/**
	 * Recursively calls the sort function, effectively splitting and sorting the smaller array each time
	 * @param a - array of Comparable type
	 * @param aux - array of Comparable type
	 * @param lo - index of first item in subarray
	 * @param hi - index of last item in subarray
	 */
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);     // sorts the left side
		sort(a, aux, mid+1, hi);   // sorts the right side
		merge(a, aux, lo, mid,hi); // merge the two sides
	}

	/**
	 * top-down merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeTD ( Comparable[] x, int n ) {
		Comparable[] aux = new Comparable[x.length];
		sort(x, aux, 0, x.length-1);
	}
	
	/**
	 * bottom-up merge sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortMergeBU ( Comparable[] x, int n ) {
		Comparable[] aux = new Comparable[n];              // Creates an auxilliary array
		for (int len = 1; len < n; len *= 2) {
			for (int lo = 0; lo < n-len; lo += len+len) {  // divide into increasingly large parts
				int mid = lo+len-1;                        // Gets the middle index
				int hi = Math.min(lo +len+len-1, n-1);
				merge (x, aux, lo, mid, hi);
			}
		}
		
		
	}
}
