package com.g4.java.crossover;

import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.RandomGenerator;

public class GeneCrossOver implements Crossover {

  @Override
  public Individual[] cross(Individual[] entities) {
    int size = entities[0].getLupusArray().length;
    List<double[][]> dad = entities[0].getLupusMatrix();
    List<double[][]> mom = entities[1].getLupusMatrix();

    double[] son1 = new double[size];
    double[] son2 = new double[size];
    int cutPoint = RandomGenerator.getInt(1, dad.size());

    int index = 0;
    for (int i = 0; i < cutPoint; i++) {
      double[][] dadMatrix = dad.get(i);
      double[][] momMatrix = mom.get(i);

      for (int j = 0; j < dadMatrix.length; j++) {
        for (int k = 0; k < dadMatrix[j].length; k++) {
          son1[index] = dadMatrix[j][k];
          son2[index++] = momMatrix[j][k];
        }
      }
    }

    for (int i = cutPoint; i < dad.size(); i++) {
      double[][] dadMatrix = dad.get(i);
      double[][] momMatrix = mom.get(i);

      for (int j = 0; j < dadMatrix.length; j++) {
        for (int k = 0; k < dadMatrix[j].length; k++) {
          son1[index] = dadMatrix[j][k];
          son2[index++] = momMatrix[j][k];
        }
      }
    }

    Individual indSon1 = Individual
        .creator(entities[0].getData(), son1);
    Individual indSon2 = Individual
        .creator(entities[0].getData(), son2);

    return new Individual[] { indSon1, indSon2 };

  }

}
