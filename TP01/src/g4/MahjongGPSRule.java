package g4;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

public class MahjongGPSRule implements GPSRule {

  private int indexToUse;

  public MahjongGPSRule(int indexToUse) {
    this.indexToUse = indexToUse;
  }

  @Override
  public Integer getCost() {
    return 2;
  }

  @Override
  public String getName() {
    return String.format("Get Payer with index: %d", indexToUse);
  }

  @Override
  public GPSState evalRule(GPSState state) throws NotAppliableException {
    MahjongGPSState original = (MahjongGPSState) state;

    if ( this.indexToUse >= original.getBoard().getPayersCount() ) {
      throw new NotAppliableException();
    }

    MahjongGPSState clone = null;
    try {
      clone = (MahjongGPSState) original.clone();
    } catch (CloneNotSupportedException e) {
      throw new NotAppliableException();
    }

    Board board = clone.getBoard();
    Pair toRemove = board.getPairs()[indexToUse];

    board.setItem(toRemove.getPosition1(), null);
    board.setItem(toRemove.getPosition2(), null);

    return clone;
  }

}
