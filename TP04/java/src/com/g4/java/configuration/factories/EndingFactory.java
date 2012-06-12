package com.g4.java.configuration.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.g4.java.ending.ContentEnding;
import com.g4.java.ending.EndingMethod;
import com.g4.java.ending.MaxGenerationEnding;
import com.g4.java.ending.MixEnding;
import com.g4.java.ending.OptimumOrFitnessEnding;
import com.g4.java.ending.StructuralEnding;

public class EndingFactory {

  private Properties properties;

  public EndingFactory(Properties properties) {
    this.properties = properties;
  }

  public EndingMethod loadEnding() {
    List<EndingMethod> selected = new ArrayList<EndingMethod>();
    String[] endings = properties.getProperty("ending").split("/");
    for (int i = 0; i < endings.length; i++) {
      String endingMethod = endings[i].trim().toUpperCase();

      if (endingMethod.equals(EndingEnum.MAXGENERATION.getName())) {
        int iterationsToEnd = 1;
        if (properties.getProperty("MaxGeneration.iterationToEnd") != null) {
          iterationsToEnd = Integer.valueOf(properties
              .getProperty("MaxGeneration.iterationToEnd"));
        }

        selected.add(new MaxGenerationEnding(iterationsToEnd));
      } else if (endingMethod.equals(EndingEnum.CONTENT.getName())) {
        double improvement = 1;
        if (properties.getProperty("Content.improvement") != null) {
          improvement = Double.valueOf(properties
              .getProperty("Content.improvement"));
        }
        int iterationsToImprove = 1;
        if (properties.getProperty("Content.iterationToImprove") != null) {
          iterationsToImprove = Integer.valueOf(properties
              .getProperty("Content.iterationToImprove"));
        }
        selected
            .add(new ContentEnding(iterationsToImprove, improvement));

      } else if (endingMethod.equals(EndingEnum.OPTIMUM.getName())) {
        double optimum = 1;
        if (properties.getProperty("Optimum.optimum") != null) {
          optimum = Double.valueOf(properties
              .getProperty("Optimum.optimum"));
        }
        double tolerance = 1;
        if (properties.getProperty("Optimum.tolerance") != null) {
          tolerance = Double.valueOf(properties
              .getProperty("Optimum.tolerance"));
        }
        selected.add(new OptimumOrFitnessEnding(optimum, tolerance));
      } else if (endingMethod.equals(EndingEnum.STRUCTURAL.getName())) {
        int iterationsToCheck = 1;
        if (properties.getProperty("Structural.iterationsToCheck") != null) {
          iterationsToCheck = Integer.valueOf(properties
              .getProperty("Structural.iterationsToCheck"));
        }
        int percent = 1;
        if (properties.getProperty("Structural.iterationToEnd") != null) {
          percent = Integer.valueOf(properties
              .getProperty("Structural.iterationToEnd"));
        }
        int popSize = 1;
        if (properties.getProperty("Structural.popSize") != null) {
          popSize = Integer.valueOf(properties
              .getProperty("Structural.popSize"));
        }
        selected.add(new StructuralEnding(iterationsToCheck, percent,
            popSize));
      }
    }

    return new MixEnding(selected);
  }

}
