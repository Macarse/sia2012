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

//  @Override
//  public List<GPSRule> getRules(GPSState state) {
//    List<GPSRule> rules = new ArrayList<GPSRule>();
//
//    MahjongGPSState gpsState = (MahjongGPSState) state;
//    int count = gpsState.getBoard().getPayersCount();
//
//    for (int i = 0 ; i < count ; i++ ) {
//      rules.add(new MahjongGPSRule(i));
//    }
//
//    System.out.println("rules count: " + rules.size());
//
//    return rules;
//  }
//
//  @Override
//  public Integer getHValue(GPSState state1) {
//
//    MahjongGPSState state = (MahjongGPSState) state1;
//    Board board = state.getBoard();
//
//    int pairs = board.getTilesCount() / 2;
//    return pairs;
//    /*
//    Pair pair = state.getMove();
//    int height = pair.getPosition1().getLayer() +
//        pair.getPosition2().getLayer();
//
//    int ret = pairs - height;
//
//    // Goal
//    if ( pairs == 0 ) {
//      return 0;
//    }
//
//    // Dead end
//    if ( board.getPayersCount() == 0) {
//      return Integer.MAX_VALUE;
//    }
//
//    return (ret > 0) ? ret : 1;*/
//
//  }

}
