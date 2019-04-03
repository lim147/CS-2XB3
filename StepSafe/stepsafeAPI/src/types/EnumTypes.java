package types;

/**
 *  The {@code FundamentalTypes} class holds types to store crime information
 *  
 *  @author Alice Ip
 *  @author Meijing Li
 *  @author Robert Vardy
 *  @author Indika Wijesundera
 *  @version 1.0
 *  @since 2019-04-03
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
	 * Data type for Hood
	 */
	class Hood{
		int id;
		String area;
	}

}
