package com.g4.java.ending;

import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.Selection;

public class OptimumOrFitnessEnding implements EndingMethod{

	private double optimum;
	private double tolerance;
	private Selection elite; 
	
	public OptimumOrFitnessEnding(double optimum, double tolerance) {
		this.optimum = optimum;
		this.tolerance = tolerance;
		elite = new EliteSelection(1);
	}
	
	@Override
	public boolean shouldEnd(List<Individual> population, int iterations) {
		Individual best = elite.select(population, 0).get(0);

		return Math.abs((best.getApptitude() - optimum)) < tolerance;
	}
	
}
