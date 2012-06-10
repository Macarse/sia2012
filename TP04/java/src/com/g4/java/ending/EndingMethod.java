package com.g4.java.ending;

import java.util.List;

import com.g4.java.model.Individual;

public interface EndingMethod {
	
	boolean shouldEnd(List<Individual> population, int iterations);
}
