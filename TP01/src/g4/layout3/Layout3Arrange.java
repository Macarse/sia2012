package g4.layout3;

import aga.mahjong.core.Board;
import aga.mahjong.core.IArrangeStrategy;
import aga.mahjong.core.Position;
import aga.mahjong.core.Tile;
import aga.mahjong.core.TileKind;

public class Layout3Arrange implements IArrangeStrategy {

  @Override
  public void arrange(Board board) {
    board.setItem(new Position(0, 0, 0), new Tile(TileKind.Dot, 1));
    board.setItem(new Position(0, 2, 0), new Tile(TileKind.Dot, 1));
    board.setItem(new Position(0, 4, 0), new Tile(TileKind.Character, 5));
    board.setItem(new Position(0, 8, 0), new Tile(TileKind.Dot, 2));
    board.setItem(new Position(0, 10, 0), new Tile(TileKind.Bamboo, 1));
    board.setItem(new Position(0, 12, 0), new Tile(TileKind.Character, 5));

    board.setItem(new Position(0, 0, 2), new Tile(TileKind.Wind, 1));
//
    board.setItem(new Position(0, 8, 4), new Tile(TileKind.Dot, 2));
//    
    board.setItem(new Position(0, 12, 4), new Tile(TileKind.Character, 6));
//    
    board.setItem(new Position(0, 6, 6), new Tile(TileKind.Wind, 1));
    board.setItem(new Position(0, 10, 6), new Tile(TileKind.Wind, 8));
    board.setItem(new Position(0, 12, 6), new Tile(TileKind.Dot, 1));
//
    board.setItem(new Position(0, 6, 8), new Tile(TileKind.Character, 4));
//
    board.setItem(new Position(0, 2, 10), new Tile(TileKind.Character, 4));
    board.setItem(new Position(0, 4, 10), new Tile(TileKind.Character, 6));
    board.setItem(new Position(0, 8, 10), new Tile(TileKind.Wind, 8));
    board.setItem(new Position(0, 12, 10), new Tile(TileKind.Bamboo, 1));
//
    board.setItem(new Position(0, 0, 12), new Tile(TileKind.Dot, 1));
//    board.setItem(new Position(0, 6, 12), new Tile(TileKind.Dragon, 1));
//    board.setItem(new Position(0, 10, 12), new Tile(TileKind.Dragon, 1));

    
  }

}
