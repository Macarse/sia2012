package g4.heuristics;

import aga.mahjong.core.Board;
import g4.MahjongGPSState;
import gps.api.GPSState;

public class HStar implements Heuristic {

  @Override
  public float getValue(GPSState state) {
    Board board = ((MahjongGPSState) state).getBoard();

    // Dead end
    if ( 0 == board.getPayersCount() ) {
      return Float.MAX_VALUE;
    }

    return board.getTilesCount() * .5f;
  }

}
