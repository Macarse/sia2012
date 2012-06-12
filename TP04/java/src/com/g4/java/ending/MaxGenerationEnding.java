package com.g4.java.ending;

import java.util.List;

import com.g4.java.model.Individual;

public class MaxGenerationEnding implements EndingMethod{

	private int iterationsToEnd;
	
	public MaxGenerationEnding(int iterationsToEnd) {
		this.iterationsToEnd = iterationsToEnd;
	}
	
	@Override
	public boolean shouldEnd(List<Individual> population, int iterations) {
		return iterations == iterationsToEnd;
	}

}
