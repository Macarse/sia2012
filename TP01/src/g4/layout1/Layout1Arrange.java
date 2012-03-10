package g4.layout1;

import aga.mahjong.core.Board;
import aga.mahjong.core.IArrangeStrategy;
import aga.mahjong.core.Position;
import aga.mahjong.core.Tile;
import aga.mahjong.core.TileKind;

public class Layout1Arrange implements IArrangeStrategy {

  @Override
  public void arrange(Board board) {
    board.setItem(new Position(0, 0, 0), new Tile(TileKind.Dot, 1));
    board.setItem(new Position(0, 2, 0), new Tile(TileKind.Dot, 1));

    board.setItem(new Position(0, 0, 2), new Tile(TileKind.Character, 2));
    board.setItem(new Position(0, 2, 2), new Tile(TileKind.Bamboo, 3));

    board.setItem(new Position(0, 1, 4), new Tile(TileKind.Character, 2));
    board.setItem(new Position(1, 1, 4), new Tile(TileKind.Dot, 1));
    board.setItem(new Position(2, 1, 4), new Tile(TileKind.Bamboo, 3));
    board.setItem(new Position(3, 1, 4), new Tile(TileKind.Dot, 1));

  }

}
