package com.g4.java;

import java.util.ArrayList;
import java.util.List;

import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class FunctionResolver {

  private static final int POP_SIZE = 50;
  private static final int MAX_GENERATIONS = 1;

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

      individual.setData((MWArray) createIndividualResult[0]);
      individual.setApptitude(function.eval(individual));

      population.add(individual);
    }

    System.out.println("Whole creation process took: " + (System.currentTimeMillis() - creationStartTime));

    EliteSelection selection = new EliteSelection();
    List<Individual> best = selection.select(population, 1);
    System.out.println("Best ind with appt " + best.get(0).getApptitude());

    for(int generation = 0 ; generation < MAX_GENERATIONS ; ++generation) {
      // BLA BLA
    }
    
  }
}
