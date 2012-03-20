package edificios2;

import edificios.Board;
import edificios.BuildingState;
import edificios.Settings;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

import java.awt.Point;

public class BuildingsRule2 implements GPSRule {

	//Cabeza pero works
	private static Point next;
	
	private int height;
	
	public BuildingsRule2(int height) {
		this.height = height;
	}

	@Override
	public Integer getCost() {
		return 1;
	}

	@Override
	public String getName() {
		String name = "Set " + height + " at the first valid position";
		name += " - Board iteration: " + Settings.strategy.getName();
		return name;
	}

	@Override
	public String toString() {
		return getName();
	}

	@Override
	public GPSState evalRule(GPSState state) throws NotAppliableException {
		Board board = ((BuildingState) state).getCurrentBoard();
		if (height == 1) {
			next = Settings.strategy.getNext(state);
		}
		//board.printBoard();
		if (board.validatePosition(next.x, next.y, height)) {
			return new BuildingState(board.duplicateAndSet(next.x, next.y, height));
		} else {
			throw new NotAppliableException();
		}
	}

}
