package com.g4.java.crossover;

import com.g4.java.model.Individual;

public interface Crossover {
	
  Individual[] cross(Individual[] entities);
  
  boolean shouldApply();
}
