package aga.mahjong.core;

import java.io.Serializable;

public final class Tile implements Serializable {
	private static final long serialVersionUID = -1138962143340254654L;

	private final TileKind kind;
	private final int number;

	public TileKind getKind() {
		return kind;
	}

	public int getNumber() {
		return number;
	}

	public Tile(TileKind kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		String str = "";
		switch (getKind()) {
		case Bamboo:
			str = "B";
			break;
		case Character:
			str = "C";
			break;
		case Dot:
			str = "D";
			break;
		case Dragon:
			str = "R";
			break;
		case Flower:
			str = "F";
			break;
		case Season:
			str = "S";
			break;
		case Wind:
			str = "W";
			break;
		}
		return String.format("%1$s%2$s", str, getNumber());
	}

	public static boolean isMatch(Tile a, Tile b) {
		if (a.getKind().equals(b.getKind())) {
			if (a.getKind().equals(TileKind.Season)
					|| a.getKind().equals(TileKind.Flower)) {
				return true;
			} else {
				return a.getNumber() == b.getNumber();
			}
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kind == null) ? 0 : kind.hashCode());
		result = prime * result + number;
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
		Tile other = (Tile) obj;
		if (kind != other.kind)
			return false;
		if (number != other.number)
			return false;
		return true;
	}
}
