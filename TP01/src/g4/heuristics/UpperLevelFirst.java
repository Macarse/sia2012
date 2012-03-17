package g4.heuristics;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;
import g4.MahjongGPSState;
import gps.api.GPSState;

public class UpperLevelFirst implements Heuristic {

	@Override
	public Integer getValue(GPSState state1) {

	    MahjongGPSState state = (MahjongGPSState) state1;
	    Board board = state.getBoard();

	    int pairs = board.getTilesCount() / 2;
	    Pair pair = state.getMove();
	    int height = pair.getPosition1().getLayer() +
	        pair.getPosition2().getLayer();

	    int ret = pairs - height;

	    // Goal
	    if ( pairs == 0 ) {
	      return 0;
	    }

	    // Dead end
	    if ( board.getPayersCount() == 0) {
	      return Integer.MAX_VALUE;
	    }


	    return (ret > 0) ? ret : 1;

	  }
}
