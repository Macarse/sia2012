package aga.mahjong.core;

import java.util.ArrayList;
import java.util.Collection;

public class TileSet {
	private static ArrayList<Tile> list;

	public static Collection<Tile> getAllTiles() {
		if (list == null) {
			list = new java.util.ArrayList<Tile>();
			for (int n = 1; n <= 4; n++) {
				for (int i = 1; i <= 9; i++) {
					list.add(new Tile(TileKind.Dot, i));
				}
			}
			for (int n = 1; n <= 4; n++) {
				for (int i = 1; i <= 9; i++) {
					list.add(new Tile(TileKind.Bamboo, i));
				}
			}
			for (int n = 1; n <= 4; n++) {
				for (int i = 1; i <= 9; i++) {
					list.add(new Tile(TileKind.Character, i));
				}
			}
			for (int n = 1; n <= 4; n++) {
				for (int i = 1; i <= 4; i++) {
					list.add(new Tile(TileKind.Wind, i));
				}
			}
			for (int n = 1; n <= 4; n++) {
				for (int i = 1; i <= 3; i++) {
					list.add(new Tile(TileKind.Dragon, i));
				}
			}
			for (int i = 1; i <= 4; i++) {
				list.add(new Tile(TileKind.Season, i));
			}
			for (int i = 1; i <= 4; i++) {
				list.add(new Tile(TileKind.Flower, i));
			}

			assert list.size() == 144;
		}
		return list;
	}
}
