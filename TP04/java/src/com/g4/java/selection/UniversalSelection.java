package com.g4.java.selection;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class UniversalSelection implements Selection {

	@Override
	public List<Individual> select(List<Individual> population, int toSelect, int generation) {
		List<Individual> newGeneration = new ArrayList<Individual>();

        double distance = 1.0d / toSelect;
        double r = RandomGenerator.getDouble() / toSelect;
        
        for (int i = 0; i < toSelect; i++) {
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
