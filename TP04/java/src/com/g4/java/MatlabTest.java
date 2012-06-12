package com.g4.java;

import com.g4.java.util.InputValues;
import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class MatlabTest {

  
  public static void main(String[] args) {
    try {
      ANN ann = new ANN();

      Object[] inputResult = ann.generateInputFromFile(4, "samples3.txt", .80f, 0);
      InputValues.getInstance().setInputs((MWArray) inputResult[0]);
      InputValues.getInstance().setExpectedOutputs((MWArray) inputResult[1]);
      InputValues.getInstance().setInputsTest((MWArray) inputResult[2]);
      InputValues.getInstance().setExpectedOutputsTest((MWArray) inputResult[3]);

      Object[] createIndividualResult = ann.createIndividual(1,
          InputValues.getInstance().getInputs(),
          InputValues.getInstance().getExpectedOutputs(),
          InputValues.getInstance().getInputsTest(),
          InputValues.getInstance().getExpectedOutputsTest());

      MWArray weights = (MWArray) createIndividualResult[0];

      Object[] evalResult = ann.evalANN(2, weights,
          InputValues.getInstance().getInputs(),
          InputValues.getInstance().getExpectedOutputs(),
          InputValues.getInstance().getInputsTest(),
          InputValues.getInstance().getExpectedOutputsTest());

      System.out.println("error1: " + evalResult[0] + " error2: " + evalResult[1]);

    } catch (MWException e) {
      e.printStackTrace();
    }
  }

}
