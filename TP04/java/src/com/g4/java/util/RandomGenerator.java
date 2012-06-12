package com.g4.java.util;

import java.util.Random;

public class RandomGenerator {

	public static Random random = new Random();

	public static int getInt(int lowerBound, int upperBound) {
		if (lowerBound == upperBound) {
			return lowerBound;
		}
		return random.nextInt(upperBound - lowerBound) + lowerBound;
	}

	public static double getDouble(double lowerBound, double upperBound) {
		return random.nextDouble() * Math.abs(upperBound - lowerBound) + Math.min(lowerBound, upperBound);
	}

	public static int getInt(int upperBound) {
		return random.nextInt(upperBound);
	}

	public static int getInt() {
		return random.nextInt();
	}

	public static double getDouble() {
		return random.nextDouble();
	}

	public static boolean getBoolean(double trueProbalility) {
		return random.nextDouble() < trueProbalility;
	}

}
