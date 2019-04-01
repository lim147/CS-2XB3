package types;

/**
 *  The {@code FundamentalTypes} class holds types to store crime information
 *  @author Alice Ip, Meijing Li, Robert Vardy, Indika Wijesundera
 *  @version 1.0
 *  @since 2019-03-08
 */

public class EnumTypes {
	
	/**
	 * Enum type for premise of the crime
	 */
	enum Premise{
		outside, house, commercial, apartment, other;
	}
	
	/**
	 * Enum type for Major Crime Indicator
	 */
	enum MCI {
		assult, breakAndEnter, robbery;
	}
	
	/**
	 * Data type for coordinate
	 */
	class CoordinateT{
		float x;
		float y;
	}
	
	/**
	 * Data type for Hood
	 */
	class Hood{
		int id;
		String area;
	}
	
	public static void main(String[] args) {
		System.out.println("Testing Git");
		// Avocado
	}

}
