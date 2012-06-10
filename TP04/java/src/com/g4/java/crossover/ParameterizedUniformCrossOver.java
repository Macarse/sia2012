package com.g4.java.crossover;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class ParameterizedUniformCrossOver implements Crossover {

	private double prob;
	private double crossProb;

	public ParameterizedUniformCrossOver(double prob, double crossProb) {
		this.prob = prob;
		this.crossProb = crossProb;
	}

	@Override
	public Individual[] cross(Individual[] entities) {
		double[] dad = entities[0].getLupusArray();
		double[] mom = entities[1].getLupusArray();
		double[] son1 = new double[dad.length];
		double[] son2 = new double[dad.length];

		for (int i = 0; i < dad.length; i++) {
			son1[i] = dad[i];
			son2[i] = mom[i];
		}

		for (int i = 0; i < dad.length; i++) {
			if (RandomGenerator.getDouble() < this.prob) {
				double aux = son1[i];
				son1[i] = son2[i];
				son2[i] = aux;
			}
		}

		Individual indSon1 = Individual.creator(entities[0].getData(), son1);
		Individual indSon2 = Individual.creator(entities[0].getData(), son2);

		return new Individual[] { indSon1, indSon2 };
	}

	@Override
	public boolean shouldApplied() {
		return RandomGenerator.getDouble() < crossProb;
	}

}
