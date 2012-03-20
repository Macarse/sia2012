package edificios2;

import edificios.Board;
import edificios.BuildingProblem;
import gps.api.GPSState;

public class BuildingProblem2 extends BuildingProblem {

	// Needed by MRV to access H function to see if it is infinite
	public static BuildingProblem2 instance;
	
	public BuildingProblem2(Board board) {
		super(board);
		instance = this;
	}

	@Override
	protected void initializeRules() {
		int maxHeight = initBoard.getSize();
		for (int i = 1; i <= maxHeight; i++) {
			rules.add(new BuildingsRule2(i));
		}
	}

	@Override
	protected void sortRules() {
		// nothing for now
	}

	@Override
	public Integer getHValue(GPSState state) {
		return heuristic.getH(state);
	}
}
