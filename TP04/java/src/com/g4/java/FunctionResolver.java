package com.g4.java;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.crossover.SinglePointCrossOver;
import com.g4.java.model.Individual;
import com.g4.java.reproduction.MonogamousReproduction;
import com.g4.java.selection.EliteSelection;
import com.g4.java.util.InputValues;
import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class FunctionResolver {

  private static final int POP_SIZE = 20;
  private static final int MAX_GENERATIONS = 10;

  private List<Individual> population = new ArrayList<Individual>(POP_SIZE);

  public static void main(String[] args) {
    FunctionResolver functionResolver = new FunctionResolver();

    try {
      functionResolver.run();
    } catch (MWException e) {
      System.err.println(e.getCause());
      System.exit(0);
    }
  }
  
  private void run() throws MWException {
    ANN ann = null;

    // Init the matlab code.
      ann = new ANN();

    // Create the input values based on samples3.txt
    Object[] inputResult = ann.generateInputFromFile(4, "samples3.txt", .80f, 0);
    InputValues.getInstance().setInputs((MWArray) inputResult[0]);
    InputValues.getInstance().setExpectedOutputs((MWArray) inputResult[1]);
    InputValues.getInstance().setInputsTest((MWArray) inputResult[2]);
    InputValues.getInstance().setExpectedOutputsTest((MWArray) inputResult[3]);

    // Create the evaluation function.
    Function function = new Function(ann);
    long creationStartTime = System.currentTimeMillis();

    // Create the initial population
    for (int i = 0; i < POP_SIZE; i++) {
      Individual individual = new Individual();
      Object[] createIndividualResult = ann.createIndividual(1,
          InputValues.getInstance().getInputs(),
          InputValues.getInstance().getExpectedOutputs(),
          InputValues.getInstance().getInputsTest(),
          InputValues.getInstance().getExpectedOutputsTest());

      individual.setData((MWCellArray) createIndividualResult[0]);
      population.add(individual);
    }

    // Calculate the aptitude for every individual.
    for (int i = 0 ; i < POP_SIZE ; i++ ) {
      population.get(i).setApptitude(function.eval(population.get(i)));
    }

    System.out.println("Whole creation process took: " + (System.currentTimeMillis() - creationStartTime));

    EliteSelection selection = new EliteSelection();

    for(int i = 0 ; i < MAX_GENERATIONS ; ++i) {
      List<Individual> best = selection.select(population, POP_SIZE / 2);
      List<Individual[]> parents = MonogamousReproduction.getParents(best);
      List<Individual> generation = new ArrayList<Individual>();
      List<Individual> sons = new ArrayList<Individual>();
      for (Individual[] family : parents) {
        generation.add(family[0]);
        generation.add(family[1]);

        Individual[] childs = SinglePointCrossOver.cross(family);
        sons.add(childs[0]);
        sons.add(childs[1]);
      }
      
      
    }
    
  }
}
