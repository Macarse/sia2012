package com.g4.java.selection;

import java.util.List;

import com.g4.java.model.Individual;

public interface Selection {
	
  List<Individual> select(List<Individual> population, final int generation);

  List<Individual> select(List<Individual> population, final int generation, int ggToSelect);
  
}
