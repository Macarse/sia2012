package g4;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

public class MahjongGPSRule implements GPSRule {

	private static float cost = 1;
	private int indexToUse;
   
  
  public MahjongGPSRule(int indexToUse) {
    this.indexToUse = indexToUse;
  }

  public static void setCost(float cost1){
	  cost = cost1;
  }
  @Override
  public float getCost() {
    return cost;
  }

  @Override
  public String getName() {
    return String.format("Get Payer with index: %d", indexToUse);
  }

  @Override
  public GPSState evalRule(GPSState state) throws NotAppliableException {
    MahjongGPSState original = (MahjongGPSState) state;

    if ( original.getBoard().getPayersCount() == 0 ) {
      throw new NotAppliableException();
    }

    Pair pair = null;
    try {
      pair = original.getBoard().getPairs()[indexToUse];
    } catch (IndexOutOfBoundsException e) {
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
    clone.setMove(pair);

    return clone;
  }

}
