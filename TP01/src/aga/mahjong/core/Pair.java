package aga.mahjong.core;

public class Pair {
	private final Position position1;
	private final Position position2;

	public Position getPosition1() {
		return position1;
	}

	public Position getPosition2() {
		return position2;
	}

	public Pair(Position pos1, Position pos2) {
		position1 = pos1;
		position2 = pos2;
	}

	@Override
	public String toString() {
		return String.format("%1$s - %2$s", getPosition1(), getPosition2());
	}

	@Override
	public boolean equals(Object o) {
		Pair x = this;
		Pair y = (Pair) o;
		return ((x.getPosition1().equals(y.getPosition1()) && x.getPosition2()
				.equals(y.getPosition2())) || (x.getPosition1().equals(
				y.getPosition2()) && x.getPosition2().equals(y.getPosition1())));
	}

	@Override
	public int hashCode() {
		return 0; // TODO: optimize
	}

}
