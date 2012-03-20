package edificios2;

import edificios.Board;
import edificios.BuildingState;
import gps.api.GPSState;

import java.awt.Point;

public class MRVStrategy implements BoardIteratorStrategy {

	@Override
	public String getName() {
		return "MRV iteration";
	}

	@Override
	public Point getNext(GPSState state) {
		Board board = ((BuildingState) state).getCurrentBoard();
		int size = board.getSize();
		int[][] buildings = board.getBuildings();
		int min = Integer.MAX_VALUE;
		Point ret = new Point();
		int i, j, k;
		int lastr = board.getLastRow();
		int lastc = board.getLastCol();
		for (i = 0; i < size && min != 0; i++) {
			for (j = 0; j < size && min != 0; j++) {
				if (buildings[i][j] == 0) {
					int count = 0;
					for (k = 1; k <= size; k++) {
						if (board.validatePosition(i, j, k)) {
							buildings[i][j] = k;
							board.setLastRow(i);
							board.setLastCol(j);
							if (BuildingProblem2.instance.getHValue(state) != Integer.MAX_VALUE) {
								count++;
							} else {
								// board.printBoard();
							}
							buildings[i][j] = 0;
						}
					}
					if (count < min) {
						min = count;
						if (count == 0) {
							// System.out.println("Point:" + i + "," + j);
							// board.printBoard();
						}
						ret.x = i;
						ret.y = j;
					}
				}
			}
		}
		board.setLastRow(lastr);
		board.setLastCol(lastc);
		return ret;
	}

}
