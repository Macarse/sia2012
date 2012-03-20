package edificios2;

import gps.api.GPSState;

import java.awt.Point;

public interface BoardIteratorStrategy {

	 Point getNext(GPSState state);
	 
	 String getName();
}
