package g4.layout3;

import g4.MahjongGPSRule;
import g4.MahjongGPSState;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

import java.util.ArrayList;
import java.util.List;

import aga.mahjong.core.Board;

public class Layout3Problem implements GPSProblem {

  private List<GPSRule> rules;

  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout3());
    Layout3Arrange arrange = new Layout3Arrange();
    arrange.arrange(board);
    gpsState.setBoard(board);
    
    assert(board.getPayersCount() > 0);
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

  @Override
  public List<GPSRule> getRules() {
    if ( rules != null ) {
      return rules;
    }

    rules = new ArrayList<GPSRule>();

    MahjongGPSState gpsState = (MahjongGPSState) getInitState();
    int count = gpsState.getBoard().getTilesCount();

    for (int i = 0 ; i < count * .5 + 1 ; i++ ) {
      rules.add(new MahjongGPSRule(i));
    }

    System.out.println("rules count: " + count);

    return rules;
  }

  @Override
  public Integer getHValue(GPSState state) {
    return null;
  }

}
