package g4.layout2;

import java.util.ArrayList;
import java.util.List;

import aga.mahjong.core.Board;

import g4.MahjongGPSRule;
import g4.MahjongGPSState;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

public class Layout2Problem implements GPSProblem {

  private List<GPSRule> rules;

  @Override
  public GPSState getInitState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout2());
    Layout2Arrange arrange = new Layout2Arrange();
    arrange.arrange(board);
    gpsState.setBoard(board);
    
    assert(board.getPayersCount() > 0);
    return gpsState;
  }

  @Override
  public GPSState getGoalState() {
    MahjongGPSState gpsState = new MahjongGPSState();
    Board  board = new Board(new Layout2());
    gpsState.setBoard(board);

    assert(board.getPayersCount() == 0);
    return gpsState;
  }

  @Override
  public List<GPSRule> getRules(GPSState state) {
    List<GPSRule> rules = new ArrayList<GPSRule>();

    MahjongGPSState gpsState = (MahjongGPSState) state;
    int count = gpsState.getBoard().getPayersCount();

    for (int i = 0 ; i < count ; i++ ) {
      rules.add(new MahjongGPSRule(i));
    }

    System.out.println("rules count: " + rules.size());

    return rules;
  }

  @Override
  public Integer getHValue(GPSState state) {
    return null;
  }

}
