package com.g4.java.crossover;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class SinglePointCrossOver {

  public static Individual[] cross(Individual[] entities) {
    double[] dad = entities[0].getLupusArray();
    double[] mom = entities[1].getLupusArray();

    int cutPoint = RandomGenerator.getInt(1, dad.length);
    
    return null;
  }
}
