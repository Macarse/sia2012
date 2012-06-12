package com.g4.java.mutation;

import com.g4.java.model.Individual;

public interface Mutation {

  void updateMutationProbability(int iteration);
  Individual mutate(Individual entity, int iteration);
  boolean shouldMutate();

}
