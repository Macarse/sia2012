package aga.mahjong.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Board implements Serializable {
	private static final long serialVersionUID = -5903179874925723302L;

	private ArrayList<Position> selection = new ArrayList<Position>();
	private final Layout layout;
	private Tile[][][] tiles;
	private int layerCount, rowCount, columnCount;
	private int tilesCount, payersCount;

	public static String getMove(Board a, Board b) {

	  StringBuilder sb = new StringBuilder();
	  for (int i = 0; i < a.layerCount; i++) {
      for (int j = 0; j < a.rowCount; j++) {
        for (int k = 0; k < a.columnCount; k++) {

          Tile tile1 = a.getItem(i, j, k);
          Tile tile2 = b.getItem(i, j, k);

          if ( tile1 == null && tile2 != null ) {
            sb.append(String.format("tile: %s [%d, %d, %d]\n", tile2.toString(), i, j, k));
          } else if ( tile1 != null && tile2 == null ) {
            sb.append(String.format("tile: %s [%d, %d, %d]\n", tile1.toString(), i, j, k));
          }
        }
      }
	  }

	  sb.append("\n");
	  return sb.toString();
	}

	public static Pair getMoveInPair(Board a, Board b) {

	  Position pos1 = null;
	  Position pos2 = null;

    for (int i = 0; i < a.layerCount; i++) {
      for (int j = 0; j < a.rowCount; j++) {
        for (int k = 0; k < a.columnCount; k++) {

          Tile tile1 = a.getItem(i, j, k);
          Tile tile2 = b.getItem(i, j, k);

          if ( tile1 == null && tile2 != null ) {
            if ( pos1 == null ) {
              pos1 = new Position(i, j, k);
            } else {
              pos2 =  new Position(i, j, k);
              break;
            }

          } else if ( tile1 != null && tile2 == null ) {
            if ( pos1 == null ) {
              pos1 = new Position(i, j, k);
            } else {
              pos2 =  new Position(i, j, k);
              break;
            }
          }
        }
      }
    }

    return new Pair(pos1, pos2);
  }

	public boolean isValid() {
	  HashMap<String, Integer> map = new HashMap<String, Integer>();
	  for (int i = 0; i < layerCount; i++) {
      for (int j = 0; j < rowCount; j++) {
        for (int k = 0; k < columnCount; k++) {

          Tile tile = getItem(i, j, k);
          if ( tile == null ) {
            continue;
          }

          String key = null;
          if ( tile.toString().contains("S") ) {
            key = "S";
          } else if (tile.toString().contains("F") ) {
            key = "F";
          } else {
            key = tile.toString();
          }

          Integer amount = map.get(key);
          if ( amount == null ) {
            map.put(key, 1);
          } else {
            map.put(key, amount + 1);
          }
        }
      }
    }

	  boolean ret = true;
	  
	  for (String key : map.keySet()) {
      Integer amount = map.get(key);
      if ( amount % 2 != 0 ) {
        System.out.println("ERROR: Tile: " + key + " amount: " + amount);
        ret = false;
        break;
      }
    }

	  return ret;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Board clone = new Board(layout);

		for (int i = 0; i < layerCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				for (int k = 0; k < columnCount; k++) {
					clone.tiles[i][j][k] = tiles[i][j][k];
				}
			}
		}

		clone.layerCount = layerCount;
		clone.rowCount = rowCount;
		clone.columnCount = columnCount;

		clone.tilesCount = tilesCount;
		clone.payersCount = payersCount;

		return clone;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < layerCount; i++) {
			for (int j = 0; j < rowCount; j++) {
				for (int k = 0; k < columnCount; k++) {
					if (tiles[i][j][k] == null) {
						sb.append("-");
					} else {
						sb.append(tiles[i][j][k].toString());
					}
				}
				sb.append("\n");
			}
			sb.append("\n***** Layer " + i + " ******\n");
		}

		return sb.toString();
	}

	public Tile getItem(Position pos) {
		return tiles[pos.getLayer()][pos.getRow()][pos.getColumn()];
	}

	public void setItem(Position pos, Tile value) {
		setItem(pos.getLayer(), pos.getRow(), pos.getColumn(), value);
	}

	public Tile getItem(int layer, int row, int column) {
		if (layer < getLayerCount() && row < getRowCount()
				&& column < getColumnCount() && layer >= 0 && row >= 0
				&& column >= 0) {
			return tiles[layer][row][column];
		} else {
			return null;
		}
	}

	public void setItem(int layer, int row, int column, Tile value) {
		if (layer < getLayerCount() && row < getRowCount()
				&& column < getColumnCount() && layer >= 0 && row >= 0
				&& column >= 0) {
			tiles[layer][row][column] = value;
			resetStatus();
		}
	}

	public java.util.List<Position> getSelection() {
		return selection;
	}

	public int getLayerCount() {
		return layerCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public int getColumnCount() {
		return columnCount;
	}

	public Iterable<Position> getAllPositions() {
		return layout.getPositions();
	}

	public synchronized int getTilesCount() {
		if (tilesCount < 0) {
			tilesCount = 0;
			for (Position p : getAllPositions()) {
				if (getItem(p) != null)
					tilesCount++;
			}
		}
		return tilesCount;
	}

	public int getPayersCount() {
		if (payersCount < 0) {
			payersCount = getPairs().length;
		}
		return payersCount;
	}

	public Board(Layout layout) {
		this.layout = layout;
		tiles = new Tile[layout.getLayerCount()][layout.getRowCount()][layout
				.getColumnCount()];
		layerCount = layout.getLayerCount();
		rowCount = layout.getRowCount();
		columnCount = layout.getColumnCount();
		resetStatus();
	}

	public Cell[] getFreePositions() {
		ArrayList<Cell> res = new ArrayList<Cell>();
		for (Position p : getAllPositions()) {
			if (getItem(p) != null && isFree(p))
				res.add(new Cell(p, this.getItem(p)));
		}
		return res.toArray(new Cell[res.size()]);
	}

	public boolean isFree(Position pos) {
		boolean flag1 = true;
		boolean flag2 = true;

		for (int row = pos.getRow() - 1; row <= pos.getRow() + 1; row++) {
			if (getItem(pos.getLayer(), row, pos.getColumn() - 2) != null) {
				flag1 = false;
			}

			if (getItem(pos.getLayer(), row, pos.getColumn() + 2) != null) {
				flag2 = false;
			}
		}

		if (flag1 || flag2) {
			if (pos.getLayer() < getLayerCount() - 1) {
				for (int row = pos.getRow() - 1; row <= pos.getRow() + 1; row++) {
					for (int col = pos.getColumn() - 1; col <= pos.getColumn() + 1; col++) {
						if (getItem(pos.getLayer() + 1, row, col) != null) {
							return false;
						}
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public Pair[] getPairs() {
		HashSet<Pair> res = new HashSet<Pair>();
		Cell[] positions = getFreePositions();
		for (Cell p : positions) {
			for (Cell q : positions) {
				if (!p.getPosition().equals(q.getPosition())
						&& Tile.isMatch(p.getTile(), q.getTile()))
					res.add(new Pair(p.getPosition(), q.getPosition()));
			}
		}

		return res.toArray(new Pair[res.size()]);
	}

	private void resetStatus() {
		payersCount = tilesCount = -1;
	}
}
