package com.g4.java.crossover;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class SinglePointCrossOver implements Crossover {

	private double prob;

	public SinglePointCrossOver(double prob) {
		this.prob = prob;
	}

	public Individual[] cross(Individual[] entities) {
		double[] dad = entities[0].getLupusArray();
		double[] mom = entities[1].getLupusArray();
		double[] son1 = new double[dad.length];
		double[] son2 = new double[dad.length];

		int cutPoint = RandomGenerator.getInt(1, dad.length);

		for (int i = 0; i < cutPoint; i++) {
			son1[i] = dad[i];
			son2[i] = mom[i];
		}

		for (int i = cutPoint; i < mom.length; i++) {
			son2[i] = dad[i];
			son1[i] = mom[i];
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
