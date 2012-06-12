package com.g4.java;

import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWException;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class Function {
  private ANN ann;

  public Function(ANN ann) {
    this.ann = ann;
  }

  public double eval(Individual individual) {
    double retVal;
    try {
      Object[] ret = ann.evalANN(2, individual.getData(),
          InputValues.getInstance().getInputs(),
          InputValues.getInstance().getExpectedOutputs(),
          InputValues.getInstance().getInputsTest(),
          InputValues.getInstance().getExpectedOutputsTest());
      retVal = ((MWNumericArray)ret[0]).getDouble(1);
    } catch (MWException e) {
      retVal =Double.MIN_VALUE;
    }

    return retVal;
  }
}
