package aga.mahjong.core;

import java.io.Serializable;

public final class Cell implements Serializable {
	private static final long serialVersionUID = 2303277354058270968L;
	
	private final Position position;
	private final Tile tile;

	public Position getPosition() {
		return position;
	}

	public Tile getTile() {
		return tile;
	}

	public Cell(Position pos, Tile tile) {
		this.position = pos;
		this.tile = tile;
	}

	@Override
	public String toString() {
		return String.format("%1$s = %2$s", getPosition(), getTile());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((position == null) ? 0 : position.hashCode());
		result = prime * result + ((tile == null) ? 0 : tile.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cell other = (Cell) obj;
		if (position == null) {
			if (other.position != null)
				return false;
		} else if (!position.equals(other.position))
			return false;
		if (tile == null) {
			if (other.tile != null)
				return false;
		} else if (!tile.equals(other.tile))
			return false;
		return true;
	}
	
}
