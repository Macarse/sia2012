package g4.layouts.layout3;

import g4.MahjongGPSState;
import g4.MahjongProblem;
import g4.heuristics.Heuristic;
import gps.api.GPSState;
import aga.mahjong.core.Board;

public class Layout3Problem extends MahjongProblem {

	public Layout3Problem(Heuristic heuristic1){
		this.heuristic = heuristic1;
	}
	
  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout3());
    Layout3Arrange arrange = new Layout3Arrange();
    arrange.arrange(board);
    gpsState.setBoard(board);

    if ( board.getPayersCount() == 0 ) {
      System.out.println("ERROR: Payers count == 0");
      return null;
    }

    if ( !board.isValid() ) {
      return null;
    }

    return gpsState;
  }

  @Override
  public GPSState getGoalState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout3());
    gpsState.setBoard(board);

    assert(board.getPayersCount() == 0);
    return gpsState;
  }

}

