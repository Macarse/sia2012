package edificios;

import edificios2.BoardIteratorStrategy;


/**
 * 
 * Simple struct containing static redundant data that does not belong in the states.
 *
 */

public class Settings {
	public static final int TOP = 0;
	public static final int BOTTOM = 1;
	public static final int LEFT = 2;
	public static final int RIGHT = 3;
	
	public static int[][] restrictions;
	public static BoardIteratorStrategy strategy;
}
