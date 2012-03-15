package g4.layout1;

import java.util.ArrayList;
import java.util.List;

import aga.mahjong.core.Board;

import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

public class Layout1Problem implements GPSProblem {

  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout1());
    Layout1Arrange arrange = new Layout1Arrange();
    arrange.arrange(board);
    gpsState.setBoard(board);
    
    assert(board.getPayersCount() > 0);
    return gpsState;
  }

  @Override
  public GPSState getGoalState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout1());
    gpsState.setBoard(board);

    assert(board.getPayersCount() == 0);
    return gpsState;
  }

  @Override
  public List<GPSRule> getRules() {
    List<GPSRule> rules = new ArrayList<GPSRule>();

    rules.add(new MahjongGPSRule(0));
    rules.add(new MahjongGPSRule(1));
    rules.add(new MahjongGPSRule(2));
    rules.add(new MahjongGPSRule(3));
    rules.add(new MahjongGPSRule(4));

    return rules;
  }

  @Override
  public Integer getHValue(GPSState state) {
    return null;
  }

}
