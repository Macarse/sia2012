package edificios;

import gps.api.GPSState;

public class BuildingState implements GPSState {

	private Board currentBoard;
	
	
	public BuildingState(Board board) {
		this.currentBoard = board;
	}
	
	public Board getCurrentBoard() {
		return currentBoard;
	}
	
	@Override
	public boolean compare(GPSState state) {
		return currentBoard.equals(((BuildingState) state).getCurrentBoard());
	}
	
	@Override
	public boolean isGoalState() {
		int[][] buildings = currentBoard.getBuildings();
		int n = buildings.length;
		return currentBoard.getBuildingsOnBoard() == n * n;
	}
	
	@Override
	public String toString() {
		return currentBoard.toString();
	}
	
	@Override
	public int hashCode() {
		return currentBoard.hashCode();
	}

}
