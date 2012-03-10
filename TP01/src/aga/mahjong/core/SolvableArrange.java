package aga.mahjong.core;

import java.util.ArrayList;


public class SolvableArrange implements IArrangeStrategy {
	public void arrange(Board board) {
		//TODO: implement
		java.util.Random rnd = new java.util.Random();
		ArrayList<Tile> initLayout = new ArrayList<Tile>();
		ArrayList<Tile> tiles = new ArrayList<Tile>(TileSet.getAllTiles());
		for (Position pos : board.getAllPositions()) {
			int i = rnd.nextInt(tiles.size());
			board.setItem(pos, tiles.get(i));
			initLayout.add(tiles.get(i));
			tiles.remove(i);
		}
	}
}
