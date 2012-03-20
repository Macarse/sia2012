package edificios2;

import edificios.Board;
import edificios.BuildingState;
import gps.api.GPSState;

import java.awt.Point;

public class SequenceStrategy implements BoardIteratorStrategy {

	@Override
	public String getName() {
		return "Sequence iteration";
	}
	
	@Override
	public Point getNext(GPSState state) {
		Board board = ((BuildingState) state).getCurrentBoard();
		Point ret = null;
		int size = board.getSize();
		int[][] buildings = board.getBuildings();
		for (int i = 0; i < size && ret == null; i++) {
			for (int j = 0; j < size && ret == null; j++) {
				if (buildings[i][j] == 0) {
					ret = new Point(i,j);
				}
			}
		}
		return ret;
	}

}
