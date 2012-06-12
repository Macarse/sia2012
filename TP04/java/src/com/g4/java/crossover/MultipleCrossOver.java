package com.g4.java.crossover;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class MultipleCrossOver implements Crossover {
	private int cutPointsCount;
	private double prob;

	public MultipleCrossOver(double prob, int cutPointsQty) {
		this.cutPointsCount = cutPointsQty;
		this.prob = prob;
	}

	@Override
	public Individual[] cross(Individual[] entities) {
		double[] dad = entities[0].getLupusArray();
		double[] mom = entities[1].getLupusArray();
		double[] son1 = new double[dad.length];
		double[] son2 = new double[dad.length];

		int cutPoint = 1;

		List<Integer> cutPoints = new ArrayList<Integer>(cutPointsCount);
		cutPoints.add(0);
		do {
			int auxCut = RandomGenerator.getInt(cutPoint, dad.length);
			if (!cutPoints.contains(auxCut)) {
				cutPoints.add(auxCut);
			}
		} while (cutPoints.size() <= cutPointsCount);

		Collections.sort(cutPoints);

		int k = 0;
		for (; k < cutPoints.size() - 1; k++) {
			if (k % 2 == 0) {
				for (int i = cutPoints.get(k); i < cutPoints.get(k + 1); i++) {
					son1[i] = dad[i];
					son2[i] = mom[i];
				}
			} else {
				for (int i = cutPoints.get(k); i < cutPoints.get(k + 1); i++) {
					son1[i] = mom[i];
					son2[i] = dad[i];
				}
			}
		}

		if (k % 2 == 0) {
			for (int i = cutPoints.get(k); i < dad.length; i++) {
				son1[i] = dad[i];
				son2[i] = mom[i];
			}
		} else {
			for (int i = cutPoints.get(k); i < dad.length; i++) {
				son1[i] = mom[i];
				son2[i] = dad[i];
			}
		}

		Individual indSon1 = Individual.creator(entities[0].getData(), son1);
		Individual indSon2 = Individual.creator(entities[0].getData(), son2);

		return new Individual[] { indSon1, indSon2 };

	}

	@Override
	public boolean shouldApply() {		
		return RandomGenerator.getDouble() < this.prob;
	}

}
