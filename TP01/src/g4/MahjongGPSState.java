package g4;

import gps.api.GPSState;
import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;
import aga.mahjong.core.Tile;

public class MahjongGPSState implements GPSState {
  private Board board;
  private Pair move;

  @Override
  public boolean compare(GPSState state) {
    MahjongGPSState other = (MahjongGPSState) state;

    for ( int i = 0 ; i < other.getBoard().getLayerCount(); i++) {
      for ( int j = 0 ; j < other.getBoard().getRowCount() ; j++ ) {
        for ( int k = 0 ; k < other.getBoard().getColumnCount() ; k++ ) {

          Tile tile1 = other.getBoard().getItem(i, j, k);
          Tile tile2 = board.getItem(i, j, k);

          if ( tile1 == null && tile2 != null ) {
            return false;
          } else if ( tile1 != null && tile2 == null ) {
            return false;
          } else if ( tile1 == null && tile2 == null ) {
            continue;
          } else {
            if ( !tile1.equals(tile2) ) {
              return false;
            }
          }
        }
      }
    }

    return true;
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  public Board getBoard() {
    return board;
  }

  @Override
  public String toString() {
    return "state with board: \n" + board.toString();
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    MahjongGPSState clone = new MahjongGPSState();
    Board board = (Board) this.board.clone();
    clone.setBoard(board);

    return clone;
  }

  public Pair getMove() {
    return move;
  }

  public void setMove(Pair move) {
    this.move = move;
  }
}
