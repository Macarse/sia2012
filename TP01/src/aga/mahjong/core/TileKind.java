package aga.mahjong.core;

public enum TileKind {
	None, Dot, Character, Bamboo, Wind, Dragon, Season, Flower;

	public int getValue() {
		return this.ordinal();
	}

	public static TileKind forValue(int value) {
		return values()[value];
	}
}