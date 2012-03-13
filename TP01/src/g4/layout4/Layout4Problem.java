package g4.layout4;

import g4.MahjongGPSRule;
import g4.MahjongGPSState;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import aga.mahjong.core.Board;

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

    System.out.println("rules count: " + rules.size());


    Collections.shuffle(rules, new Random(13372));
/*    Collections.sort(rules, new Comparator<GPSRule>() {

      @Override
      public int compare(GPSRule o1, GPSRule o2) {
        MahjongGPSState state1 = null;
        MahjongGPSState state2 = null;

        try {
          state1 = (MahjongGPSState) o1.evalRule(gpsState);
        } catch (NotAppliableException e) {
          return 1;
        }

        try {
          state2 = (MahjongGPSState) o2.evalRule(gpsState);
        } catch (NotAppliableException e) {
          return -1;
        }

        if ( state1.getBoard().getPayersCount() > 
        state2.getBoard().getPayersCount() ) {
          return -1;
        }

        return 0;
      }
    });*/

    return rules;
  }

  @Override
  public Integer getHValue(GPSState state) {
    return null;
  }

}
