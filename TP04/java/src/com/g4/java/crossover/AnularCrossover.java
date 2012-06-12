package com.g4.java.crossover;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class AnularCrossover implements Crossover {

	private double prob;

	public AnularCrossover(double crossoverProbability) {
		this.prob = crossoverProbability;
	}

	@Override
	public Individual[] cross(Individual[] entities) {
		double[] dad = entities[0].getLupusArray();
		double[] mom = entities[1].getLupusArray();
		double[] son1 = new double[dad.length];
		double[] son2 = new double[dad.length];

		int r = RandomGenerator.getInt(0, dad.length);
		int l = RandomGenerator.getInt(1, dad.length / 2);
		int i;
		
		for (i = 0 ; i < mom.length && i < r ; i++) {
			son1[i] = dad[i];
			son2[i] = mom[i];
		}

		for (i = r; i < mom.length && i < (r + l); i++) {
			son2[i] = mom[i];
			son1[i] = dad[i];
		}
		
		// Start at beginning
		if ( dad.length - (r+l) < 0 ) {
			for (i = 0 ; i < ((r+l) - dad.length); i++) {
				son2[i] = mom[i];
				son1[i] = dad[i];
			}
		}

		Individual newSon1 = Individual.creator(entities[0].getData(), son1);
		Individual newSon2 = Individual.creator(entities[0].getData(), son2);
		
		return new Individual[]{newSon1, newSon2};
	}

	@Override
	public boolean shouldApply() {
		return RandomGenerator.getDouble() < this.prob;
	}

}
