package g4.heuristics;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;
import aga.mahjong.core.Position;
import g4.MahjongGPSState;
import gps.api.GPSState;

public class BiggerRowsFirst implements Heuristic {

  @Override
  public float getValue(GPSState state1) {

    float ret = 0;
    MahjongGPSState state = (MahjongGPSState) state1;
    Board board = state.getBoard();
    Pair pair = state.getMove();

    int pairs = board.getTilesCount()  /2;
    int payersCount = board.getPayersCount();
    // Goal
    if ( pairs == 0 ) {
      return 0f;
    }

    // Dead end
    if ( payersCount == 0) {
      return Float.MAX_VALUE;
    }
    ret = (board.getTilesCount() - tileValue(pair.getPosition1(), board)
        - tileValue(pair.getPosition2(), board)) /2;

    if (ret <= 0 && board.getTilesCount() > 0) {
      ret = 1;
    }

    return ret;
  }

  public int tileValue(Position position, Board board) {
    return getAmountHorizontalBlockers(position, board)
        * (position.getLayer() + 1);
  }

  public int getAmountHorizontalBlockers(Position position, Board board) {

    int x = position.getColumn();
    int y = position.getRow();
    int z = position.getLayer();
    int inc = 0;
    int ret = 0;
    if (board.getItem(z, y, x + 1) != null) {
      inc = 1;
    } else {
      inc = -1;
    }
    while (board.getItem(z, y, x + inc) != null) {
      ret++;
    }
    return ret / 2;
  }

}
