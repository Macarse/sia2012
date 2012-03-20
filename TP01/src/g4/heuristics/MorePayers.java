package g4.heuristics;

import aga.mahjong.core.Board;
import g4.MahjongGPSState;
import gps.api.GPSState;

public class MorePayers implements Heuristic {

  @Override
  public float getValue(GPSState state) {
    Board board = ((MahjongGPSState) state).getBoard();
    float pairs = board.getTilesCount() * .5f;
    float payersCount = board.getPayersCount();

    // Goal
    if ( pairs == 0 ) {
      return 0f;
    }

    // Dead end
    if ( payersCount == 0) {
      return Float.MAX_VALUE;
    }

    float ret = pairs - payersCount;
    return (ret > 0) ? ret:1;
  }

}
