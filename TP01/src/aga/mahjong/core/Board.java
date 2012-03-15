package aga.mahjong.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

public class Board implements Serializable {
	private static final long serialVersionUID = -5903179874925723302L;
	
	private ArrayList<Position> selection = new ArrayList<Position>();
	private final Layout layout;
	private Tile[][][] tiles;
	private int layerCount, rowCount, columnCount;
	private int tilesCount, payersCount;

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
		tiles = new Tile[layout.getLayerCount()][layout.getRowCount()][layout.getColumnCount()];
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
