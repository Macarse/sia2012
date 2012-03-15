package aga.mahjong.core;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Layout implements Serializable {
	private static final long serialVersionUID = -3732566188318873821L;

	protected ArrayList<Position> positions = new ArrayList<Position>();
	protected String name;
	protected int layerCount;
	protected int rowCount;
	protected int columnCount;

	public java.util.ArrayList<Position> getPositions() {
		return positions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String toString() {
		return getName();
	}

	public static Layout load(InputStream stream) throws IOException {
		Layout res = new Layout();
		int count = stream.read();
		res.positions = new java.util.ArrayList<Position>(count);
		for (int i = 0; i < count; i++) {
			Position pos = Position.read(stream);
			res.getPositions().add(pos);
			res.layerCount = Math.max(res.layerCount, pos.getLayer() + 1);
			res.rowCount = Math.max(res.rowCount, pos.getRow() + 1);
			res.columnCount = Math.max(res.columnCount, pos.getColumn() + 1);
		}
		return res;
	}

	public void save(OutputStream stream) throws IOException {
		stream.write(getPositions().size());
		for (Position pos : getPositions()) {
			pos.write(stream);
		}
	}
}
