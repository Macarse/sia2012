package g4.layouts.layout4;

import aga.mahjong.core.Board;
import aga.mahjong.core.IArrangeStrategy;
import aga.mahjong.core.Position;
import aga.mahjong.core.Tile;
import aga.mahjong.core.TileKind;

public class Layout4Arrange implements IArrangeStrategy {

  @Override
  public void arrange(Board board) {
    board.setItem(new Position(0, 1, 14), new Tile(TileKind.Dot, 1));

    board.setItem(new Position(0, 3, 14), new Tile(TileKind.Dot, 1));

    board.setItem(new Position(0, 5, 14), new Tile(TileKind.Dot, 2));

    board.setItem(new Position(0, 7, 14), new Tile(TileKind.Dot, 2));

    board.setItem(new Position(0, 21, 14), new Tile(TileKind.Dot, 3));

    board.setItem(new Position(0, 23, 14), new Tile(TileKind.Dot, 3));

    board.setItem(new Position(0, 25, 14), new Tile(TileKind.Dot, 4));

    board.setItem(new Position(0, 27, 14), new Tile(TileKind.Dot, 4));

    board.setItem(new Position(0, 1, 12), new Tile(TileKind.Dot, 5));

    board.setItem(new Position(0, 3, 12), new Tile(TileKind.Dot, 5));

    board.setItem(new Position(0, 5, 12), new Tile(TileKind.Dot, 6));

    board.setItem(new Position(0, 7, 12), new Tile(TileKind.Dot, 6));

    board.setItem(new Position(0, 9, 12), new Tile(TileKind.Dot, 7));

    board.setItem(new Position(0, 12, 12), new Tile(TileKind.Dot, 7));

    board.setItem(new Position(0, 14, 12), new Tile(TileKind.Dot, 8));

    board.setItem(new Position(0, 16, 12), new Tile(TileKind.Dot, 8));

    board.setItem(new Position(0, 19, 12), new Tile(TileKind.Dot, 9));

    board.setItem(new Position(0, 21, 12), new Tile(TileKind.Dot, 9));

    board.setItem(new Position(0, 23, 12), new Tile(TileKind.Bamboo, 1));

    board.setItem(new Position(0, 25, 12), new Tile(TileKind.Bamboo, 1));

    board.setItem(new Position(0, 27, 12), new Tile(TileKind.Bamboo, 2));

    board.setItem(new Position(0, 1, 10), new Tile(TileKind.Bamboo, 2));

    board.setItem(new Position(0, 3, 10), new Tile(TileKind.Bamboo, 3));

    board.setItem(new Position(0, 5, 10), new Tile(TileKind.Bamboo, 3));

    board.setItem(new Position(0, 9, 10), new Tile(TileKind.Bamboo, 4));

    board.setItem(new Position(0, 11, 10), new Tile(TileKind.Bamboo, 4));

    board.setItem(new Position(0, 13, 10), new Tile(TileKind.Bamboo, 5));

    board.setItem(new Position(0, 15, 10), new Tile(TileKind.Bamboo, 5));

    board.setItem(new Position(0, 17, 10), new Tile(TileKind.Bamboo, 6));

    board.setItem(new Position(0, 19, 10), new Tile(TileKind.Bamboo, 6));

    board.setItem(new Position(0, 23, 10), new Tile(TileKind.Bamboo, 7));

    board.setItem(new Position(0, 25, 10), new Tile(TileKind.Bamboo, 7));

    board.setItem(new Position(0, 27, 10), new Tile(TileKind.Bamboo, 8));

    board.setItem(new Position(0, 1, 8), new Tile(TileKind.Bamboo, 8));

    board.setItem(new Position(0, 3, 8), new Tile(TileKind.Bamboo, 9));

    board.setItem(new Position(0, 5, 8), new Tile(TileKind.Bamboo, 9));

    board.setItem(new Position(0, 7, 8), new Tile(TileKind.Character, 1));

    board.setItem(new Position(0, 9, 8), new Tile(TileKind.Character, 1));

    board.setItem(new Position(0, 11, 8), new Tile(TileKind.Character, 2));

    board.setItem(new Position(0, 13, 8), new Tile(TileKind.Character, 2));

    board.setItem(new Position(0, 15, 8), new Tile(TileKind.Character, 3));

    board.setItem(new Position(0, 17, 8), new Tile(TileKind.Character, 3));

    board.setItem(new Position(0, 19, 8), new Tile(TileKind.Character, 4));

    board.setItem(new Position(0, 21, 8), new Tile(TileKind.Character, 4));

    board.setItem(new Position(0, 23, 8), new Tile(TileKind.Character, 5));

    board.setItem(new Position(0, 25, 8), new Tile(TileKind.Character, 5));

    board.setItem(new Position(0, 27, 8), new Tile(TileKind.Character, 6));

    board.setItem(new Position(0, 11, 6), new Tile(TileKind.Character, 6));

    board.setItem(new Position(0, 13, 6), new Tile(TileKind.Character, 7));

    board.setItem(new Position(0, 15, 6), new Tile(TileKind.Character, 7));

    board.setItem(new Position(0, 17, 6), new Tile(TileKind.Character, 8));

    board.setItem(new Position(0, 12, 4), new Tile(TileKind.Character, 8));

    board.setItem(new Position(0, 14, 4), new Tile(TileKind.Character, 9));

    board.setItem(new Position(0, 16, 4), new Tile(TileKind.Character, 9));

    board.setItem(new Position(0, 7, 2), new Tile(TileKind.Wind, 1));

    board.setItem(new Position(0, 9, 2), new Tile(TileKind.Wind, 1));

    board.setItem(new Position(0, 11, 2), new Tile(TileKind.Wind, 2));

    board.setItem(new Position(0, 13, 2), new Tile(TileKind.Wind, 2));

    board.setItem(new Position(0, 15, 2), new Tile(TileKind.Wind, 3));

    board.setItem(new Position(0, 17, 2), new Tile(TileKind.Wind, 3));

    board.setItem(new Position(0, 19, 2), new Tile(TileKind.Wind, 4));

    board.setItem(new Position(0, 21, 2), new Tile(TileKind.Wind, 4));

    board.setItem(new Position(0, 13, 0), new Tile(TileKind.Dragon, 1));

    board.setItem(new Position(0, 15, 0), new Tile(TileKind.Dragon, 1));

    board.setItem(new Position(1, 3, 14), new Tile(TileKind.Dragon, 2));

    board.setItem(new Position(1, 5, 14), new Tile(TileKind.Dragon, 2));

    board.setItem(new Position(1, 23, 14), new Tile(TileKind.Dragon, 3));

    board.setItem(new Position(1, 25, 14), new Tile(TileKind.Dragon, 3));

    board.setItem(new Position(1, 1, 12), new Tile(TileKind.Flower, 1));

    board.setItem(new Position(1, 3, 12), new Tile(TileKind.Flower, 2));

    board.setItem(new Position(1, 5, 12), new Tile(TileKind.Season, 1));

    board.setItem(new Position(1, 7, 12), new Tile(TileKind.Season, 2));

    board.setItem(new Position(1, 9, 12), new Tile(TileKind.Dot, 1));

    board.setItem(new Position(1, 12, 12), new Tile(TileKind.Dot, 1));

    board.setItem(new Position(1, 14, 12), new Tile(TileKind.Dot, 2));

    board.setItem(new Position(1, 16, 12), new Tile(TileKind.Dot, 2));

    board.setItem(new Position(1, 19, 12), new Tile(TileKind.Dot, 3));

    board.setItem(new Position(1, 21, 12), new Tile(TileKind.Dot, 3));

    board.setItem(new Position(1, 23, 12), new Tile(TileKind.Dot, 4));

    board.setItem(new Position(1, 25, 12), new Tile(TileKind.Dot, 4));

    board.setItem(new Position(1, 27, 12), new Tile(TileKind.Dot, 5));

    board.setItem(new Position(1, 1, 10), new Tile(TileKind.Dot, 5));

    board.setItem(new Position(1, 3, 10), new Tile(TileKind.Dot, 6));

    board.setItem(new Position(1, 5, 10), new Tile(TileKind.Dot, 6));

    board.setItem(new Position(1, 9, 10), new Tile(TileKind.Dot, 7));

    board.setItem(new Position(1, 11, 10), new Tile(TileKind.Dot, 7));

    board.setItem(new Position(1, 13, 10), new Tile(TileKind.Dot, 8));

    board.setItem(new Position(1, 15, 10), new Tile(TileKind.Dot, 8));

    board.setItem(new Position(1, 17, 10), new Tile(TileKind.Dot, 9));

    board.setItem(new Position(1, 19, 10), new Tile(TileKind.Dot, 9));

    board.setItem(new Position(1, 23, 10), new Tile(TileKind.Bamboo, 1));

    board.setItem(new Position(1, 25, 10), new Tile(TileKind.Bamboo, 1));

    board.setItem(new Position(1, 27, 10), new Tile(TileKind.Bamboo, 2));

    board.setItem(new Position(1, 3, 8), new Tile(TileKind.Bamboo, 2));

    board.setItem(new Position(1, 5, 8), new Tile(TileKind.Bamboo, 3));

    board.setItem(new Position(1, 7, 8), new Tile(TileKind.Bamboo, 3));

    board.setItem(new Position(1, 11, 8), new Tile(TileKind.Bamboo, 4));

    board.setItem(new Position(1, 13, 8), new Tile(TileKind.Bamboo, 4));

    board.setItem(new Position(1, 15, 8), new Tile(TileKind.Bamboo, 5));

    board.setItem(new Position(1, 17, 8), new Tile(TileKind.Bamboo, 5));

    board.setItem(new Position(1, 21, 8), new Tile(TileKind.Bamboo, 6));

    board.setItem(new Position(1, 23, 8), new Tile(TileKind.Bamboo, 6));

    board.setItem(new Position(1, 25, 8), new Tile(TileKind.Bamboo, 7));

    board.setItem(new Position(1, 11, 6), new Tile(TileKind.Bamboo, 7));

    board.setItem(new Position(1, 13, 6), new Tile(TileKind.Bamboo, 8));

    board.setItem(new Position(1, 15, 6), new Tile(TileKind.Bamboo, 8));

    board.setItem(new Position(1, 17, 6), new Tile(TileKind.Bamboo, 9));

    board.setItem(new Position(1, 12, 4), new Tile(TileKind.Bamboo, 9));

    board.setItem(new Position(1, 14, 4), new Tile(TileKind.Character, 1));

    board.setItem(new Position(1, 16, 4), new Tile(TileKind.Character, 1));

    board.setItem(new Position(1, 13, 2), new Tile(TileKind.Character, 2));

    board.setItem(new Position(1, 15, 2), new Tile(TileKind.Character, 2));

    board.setItem(new Position(1, 14, 0), new Tile(TileKind.Character, 3));

    board.setItem(new Position(2, 3, 12), new Tile(TileKind.Character, 3));

    board.setItem(new Position(2, 5, 12), new Tile(TileKind.Character, 4));

    board.setItem(new Position(2, 23, 12), new Tile(TileKind.Character, 4));

    board.setItem(new Position(2, 25, 12), new Tile(TileKind.Character, 5));

    board.setItem(new Position(2, 1, 11), new Tile(TileKind.Character, 5));

    board.setItem(new Position(2, 27, 11), new Tile(TileKind.Character, 6));

    board.setItem(new Position(2, 3, 10), new Tile(TileKind.Character, 6));

    board.setItem(new Position(2, 5, 10), new Tile(TileKind.Character, 7));

    board.setItem(new Position(2, 11, 10), new Tile(TileKind.Character, 7));

    board.setItem(new Position(2, 13, 10), new Tile(TileKind.Character, 8));

    board.setItem(new Position(2, 15, 10), new Tile(TileKind.Character, 8));

    board.setItem(new Position(2, 17, 10), new Tile(TileKind.Character, 9));

    board.setItem(new Position(2, 23, 10), new Tile(TileKind.Character, 9));

    board.setItem(new Position(2, 25, 10), new Tile(TileKind.Wind, 1));

    board.setItem(new Position(2, 4, 8), new Tile(TileKind.Wind, 1));

    board.setItem(new Position(2, 11, 8), new Tile(TileKind.Wind, 2));

    board.setItem(new Position(2, 13, 8), new Tile(TileKind.Wind, 2));

    board.setItem(new Position(2, 15, 8), new Tile(TileKind.Wind, 3));

    board.setItem(new Position(2, 17, 8), new Tile(TileKind.Wind, 3));

    board.setItem(new Position(2, 24, 8), new Tile(TileKind.Wind, 4));

    board.setItem(new Position(2, 11, 6), new Tile(TileKind.Wind, 4));

    board.setItem(new Position(2, 13, 6), new Tile(TileKind.Dragon, 1));

    board.setItem(new Position(2, 15, 6), new Tile(TileKind.Dragon, 1));

    board.setItem(new Position(2, 17, 6), new Tile(TileKind.Dragon, 2));

    board.setItem(new Position(3, 4, 11), new Tile(TileKind.Dragon, 2));

    board.setItem(new Position(3, 24, 11), new Tile(TileKind.Dragon, 3));

    board.setItem(new Position(3, 13, 9), new Tile(TileKind.Dragon, 3));

    board.setItem(new Position(3, 15, 9), new Tile(TileKind.Flower, 3));

    board.setItem(new Position(3, 13, 7), new Tile(TileKind.Flower, 4));

    board.setItem(new Position(3, 15, 7), new Tile(TileKind.Season, 3));

    board.setItem(new Position(4, 14, 8), new Tile(TileKind.Season, 4));


    
  }

}
