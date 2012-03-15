package g4.layout3;

import java.util.ArrayList;

import aga.mahjong.core.Layout;
import aga.mahjong.core.Position;

public class Layout3 extends Layout {
  private static final long serialVersionUID = 1L;

  public Layout3() {
    name = "Layout1";
    layerCount = 1;
    rowCount = 14;
    columnCount = 14;

    positions = new ArrayList<Position>();

    positions.add(new Position(0, 0, 0));
    positions.add(new Position(0, 2, 0));
    positions.add(new Position(0, 4, 0));
    positions.add(new Position(0, 8, 0));
    positions.add(new Position(0, 10, 0));
    positions.add(new Position(0, 12, 0));

    positions.add(new Position(0, 0, 2));

    positions.add(new Position(0, 8, 4));
    positions.add(new Position(0, 12, 4));

    positions.add(new Position(0, 6, 6));
    positions.add(new Position(0, 10, 6));
    positions.add(new Position(0, 12, 6));

    positions.add(new Position(0, 6, 8));

    positions.add(new Position(0, 2, 10));
    positions.add(new Position(0, 4, 10));
    positions.add(new Position(0, 8, 10));
    positions.add(new Position(0, 12, 10));

    positions.add(new Position(0, 0, 12));
    positions.add(new Position(0, 6, 12));
    positions.add(new Position(0, 10, 12));


  }
}
