package g4.layouts.layout1;

import java.util.ArrayList;

import aga.mahjong.core.Layout;
import aga.mahjong.core.Position;

public class Layout1 extends Layout {
  private static final long serialVersionUID = 1L;

  public Layout1() {
    name = "Layout1";
    layerCount = 4;
    rowCount = 5;
    columnCount = 7;

    positions = new ArrayList<Position>();
    positions.add(new Position(0, 0, 0));
    positions.add(new Position(0, 2, 0));
    positions.add(new Position(0, 0, 2));
    positions.add(new Position(0, 2, 2));
    positions.add(new Position(0, 1, 4));
    positions.add(new Position(1, 1, 4));
    positions.add(new Position(2, 1, 4));
    positions.add(new Position(3, 1, 4));

  }
}
