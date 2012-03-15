package g4.layout4;

import g4.MahjongGPSRule;
import g4.MahjongGPSState;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;

public class Layout4Problem implements GPSProblem {

  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout4());
    Layout4Arrange arrange = new Layout4Arrange();
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
    Board  board = new Board(new Layout4());
    gpsState.setBoard(board);

    assert(board.getPayersCount() == 0);
    return gpsState;
  }

  @Override
  public List<GPSRule> getRules(GPSState state) {
    List<GPSRule> rules = new ArrayList<GPSRule>();

    final MahjongGPSState gpsState = (MahjongGPSState) state;
    int count = gpsState.getBoard().getPayersCount();

    for (int i = 0 ; i < count ; i++ ) {
      rules.add(new MahjongGPSRule(i));
    }


    //Collections.shuffle(rules, new Random(13372));

    return rules;
  }

  @Override
  public Integer getHValue(GPSState state1) {

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
