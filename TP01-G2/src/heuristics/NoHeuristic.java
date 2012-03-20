package heuristics;

import edificios.Board;
import edificios.BuildingState;
import gps.api.GPSState;

public class NoHeuristic extends Heuristic{
	
	
	public Integer getH(GPSState state) {
		Board board = ((BuildingState) state).getCurrentBoard();
		int n = board.getSize();
		return (n * n - board.getBuildingsOnBoard());
	}
}
