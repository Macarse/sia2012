package com.g4.java.ending;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.Selection;

public class ContentEnding implements EndingMethod {

	private List<Double> stats = new ArrayList<Double>();
	private int iterationsToImprove;
	private double improvement;
	private Selection elite;

	public ContentEnding(int iterationsToImprove, double improvement) {
		this.iterationsToImprove = iterationsToImprove;
		this.improvement = improvement;
		this.elite = new EliteSelection(1);
	}

	@Override
	public boolean shouldEnd(List<Individual> population, int iterations) {
		Individual best = elite.select(population, 0).get(0);

		if (iterations < iterationsToImprove) {
			stats.add(iterations, best.getApptitude());
			return false;
		} else if (iterations == iterationsToImprove) {
			stats.add(iterations, best.getApptitude());
		} else {
			stats.set(iterations % (iterationsToImprove + 1), best.getApptitude());
		}
		
		if (stats.get(iterations % (iterationsToImprove + 1))
				- (stats.get((iterations + 1) % (iterationsToImprove + 1))) < improvement) {
			return true;
		}
		return false;
	}

}
