package com.g4.java;

import com.g4.java.model.Individual;
import com.g4.java.util.InputValues;
import com.g4.java.util.RandomGenerator;
import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class Backpropagation {

  private ANN ann;
  private int iterations;
  private double prob;
  
  public Backpropagation(ANN ann, int iterations, double prob) {
    this.prob = prob;
    this.ann = ann;
    this.iterations = iterations;
  }

  public Individual run(Individual individual) {
    Individual ret = new Individual();
    Object[] matlabRet = null;
    try {
      matlabRet = ann.backpropagation(1, individual.getData(),
          InputValues.getInstance().getInputs(),
          InputValues.getInstance().getExpectedOutputs(), iterations,
          FunctionResolver.ARCHITECTURE);
    } catch (MWException e) {
    }

    ret.setData((MWCellArray) matlabRet[0]);

    return ret;
  }

  public boolean shouldApply() {
    return RandomGenerator.getDouble() < this.prob;
  }
}
