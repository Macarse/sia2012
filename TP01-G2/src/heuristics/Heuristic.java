package heuristics;

import edificios.Board;
import edificios.Settings;
import gps.api.GPSState;

public abstract class Heuristic {
	
	public abstract Integer getH(GPSState state);
	
	// Used by MRV
	public boolean checkNoSolution(Board board) {
		int[][] buildings = board.getBuildings();
		int n = board.getSize();
		boolean ret = false;
		if (board.getBuildingsOnBoard() == 0) {
			return false;
		}
		int row = board.getLastRow();
		int col = board.getLastCol();
		/*
		for( int i = 0; i < n ; i ++){
			if(buildings[row][i] == 0 && checkHeightOptions(board, row, i) == 0)
				return true;
		}
		for( int i = 0; i < n ; i ++){
			if(buildings[i][col] == 0 && checkHeightOptions(board, i, col) == 0)
				return true;
		}
		*/
		return checkHeightConstraint(board, row, col, buildings[row][col]);
	}
	

	private boolean checkHeightConstraint(Board board, int row, int col, int k) {
		int n = board.getSize();
		int a = Settings.restrictions[Settings.TOP][col];
		int minDist = (a + k) - n - 1;
		if (row == 0 && a == 1 && k != n) {
			return true;
		}
		if (row < minDist) {
			return true;
		}
		a = Settings.restrictions[Settings.BOTTOM][col];
		minDist = (a + k) - n - 1;
		if (row == n - 1 && a == 1 && k != n) {
			return true;
		}
		if ((n - row - 1) < minDist) {
			return true;
		}
		a = Settings.restrictions[Settings.LEFT][row];
		minDist = (a + k) - n - 1;
		if (col == 0 && a == 1 && k != n) {
			return true;
		}
		if (col < minDist) {
			return true;
		}
		a = Settings.restrictions[Settings.RIGHT][row];
		minDist = (a + k) - n - 1;
		if (col == n - 1 && a == 1 && k != n) {
			return true;
		}
		if ((n - col - 1) < minDist) {
			return true;
		}
		return false;
	}
	
	public int checkHeightOptions(Board board, int row, int col) {
		int ret = 0;
		for (int k = 1; k < board.getSize(); k ++){
			if (board.validatePosition(row, col, k) && !checkHeightConstraint(board, row, col, k)) {
				ret++;
			}
		}
		return ret;
	}
}


