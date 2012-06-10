package com.g4.java.reproduction;

import java.util.List;

import com.g4.java.model.Individual;

public interface Reproduction {
  List<Individual[]> getParents(List<Individual> populations);
}
