package com.g4.java.selection;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class UniversalSelection implements Selection {

  private int toSelect;

  public UniversalSelection(final int toSelect) {
    this.toSelect = toSelect;
  }

	@Override
	public List<Individual> select(List<Individual> population, int generation) {
		return select(population, generation, this.toSelect);
	}

	@Override
	public List<Individual> select(List<Individual> population, int generation,
			int ggToSelect) {
		List<Individual> newGeneration = new ArrayList<Individual>();

        double distance = 1.0d / ggToSelect;
        double r = RandomGenerator.getDouble() / ggToSelect;
        
        for (int i = 0; i < ggToSelect; i++) {
            double f = 0;
            int j = 0;
            Individual individual = null;
            
            do {
                individual = population.get(j++);
                f += individual.getApptitude();
            } while (f < r);
            newGeneration.add(individual);
            r += distance;
        }

        return newGeneration;
	}

}
