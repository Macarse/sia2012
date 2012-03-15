package aga.mahjong.core;

import java.util.ArrayList;

public class SolvableArrange implements IArrangeStrategy {
	public void arrange(Board board) {
		java.util.Random rnd = new java.util.Random();
		ArrayList<Tile> tiles = new ArrayList<Tile>(TileSet.getAllTiles());

		while ( tiles.size() > 0 ) {
		  Tile tile1 = tiles.get(0);
		  Tile tile2 = tiles.get(0);

		  Cell[] freePositions = board.getFreePositions();
		  if ( freePositions.length == 0 ) {
		    System.out.println("Not more space left!");
		    break;
		  }

		  Position pos1 = freePositions[rnd.nextInt(freePositions.length)].getPosition();
		  board.setItem(pos1, tile1);

		  freePositions = board.getFreePositions();
		  if ( freePositions.length == 0 ) {
        System.out.println("Not more space left!");
        break;
      }

      Position pos2 = freePositions[rnd.nextInt(freePositions.length)].getPosition();
      board.setItem(pos2, tile2);

		  tiles.remove(tile1);
		  tiles.remove(tile2);
		}
	}
}
