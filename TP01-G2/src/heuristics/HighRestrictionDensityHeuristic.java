package heuristics;

import edificios.Board;
import edificios.BuildingState;
import gps.api.GPSState;

public class HighRestrictionDensityHeuristic extends Heuristic {
	
	@Override
	public Integer getH(GPSState state) {
		Board board = ((BuildingState) state).getCurrentBoard();
		if (checkNoSolution(board)) {
			return Integer.MAX_VALUE;
		}
		int n = board.getSize();
		int[][] buildings = board.getBuildings();
		int i,j, k = 0;
		double acum = 0;
		for (i = 0; i < n; i++) {
			for (j = 0 ; j < n ; j++) {
				if (buildings[i][j] == 0) {
					int count = checkHeightOptions(board, i, j);
					acum += count;
					k++;
				}
			}
		}
		acum /= k;
		double restrictivityFactor= (int) ((acum / (double) n) * 5);
		double normalization = (int) ((k*k / (double) ( n*n )) * 5);
		return (n * n - board.getBuildingsOnBoard()) + (int)(restrictivityFactor * normalization);
	}

}
