package aga.mahjong.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

public final class Position implements Serializable {
	private static final long serialVersionUID = -3293495485141107663L;
	
	private final int row;
	private final int column;
	private final int layer;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public int getLayer() {
		return layer;
	}

	public Position(int layer, int row, int column) {
		this.layer = layer;
		this.row = row;
		this.column = column;
	}

	@Override
	public String toString() {
		return String.format("[%1$s,%2$s,%3$s]", getLayer(), getRow(),
				getColumn());
	}

	public void write(OutputStream stream) throws IOException {
		stream.write((byte) layer);
		stream.write((byte) row);
		stream.write((byte) column);
	}

	public static Position read(InputStream stream) throws IOException {
		int lay = stream.read();
		int row = stream.read();
		int col = stream.read();
		return new Position(lay, row, col);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + layer;
		result = prime * result + row;
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
		Position other = (Position) obj;
		if (column != other.column)
			return false;
		if (layer != other.layer)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}
