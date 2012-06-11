package com.g4.java.ending;

import java.util.List;

import com.g4.java.model.Individual;

public class MixEnding implements EndingMethod {

  private List<EndingMethod> endingMethods;

  public MixEnding(List<EndingMethod> endingMethods) {
    this.endingMethods = endingMethods;
  }

  @Override
  public boolean shouldEnd(List<Individual> population, int iterations) {

    for (EndingMethod endingMethod : endingMethods) {
      if ( endingMethod.shouldEnd(population, iterations) ) {
        return true;
      }
    }

    return false;
  }

}
