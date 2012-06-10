package com.g4.java.mutation;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class ClassicMutation implements Mutation {

	protected double mutationPercentage;

	public ClassicMutation(double mutationPercentage) {
		this.mutationPercentage = mutationPercentage;
	}

	public Individual mutate(Individual entity, int iteration) {
		double[] bits = entity.getLupusArray();

		for (int i = 0; i < bits.length; ++i) {
			double charProba = Math.random();
			if (charProba < mutationPercentage * 2) {
				bits[i] = RandomGenerator.getDouble(-1.5, 1.5);
			}
		}
		return Individual.creator(entity.getData(), bits);
	}

	public double getMutationProbability() {
		return mutationPercentage;
	}

	public boolean shouldMutate() {
		double prob = RandomGenerator.getDouble();
		return prob < mutationPercentage;
	}

  @Override
  public void updateMutationProbability(int iteration) {
  }

}
