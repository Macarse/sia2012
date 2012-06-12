package com.g4.java;

import com.mathworks.toolbox.javabuilder.MWArray;

public class InputValues {

  private MWArray inputs;
  private MWArray expectedOutputs;
  private MWArray inputsTest;
  private MWArray expectedOutputsTest;

  private static InputValues instance = new InputValues();

  public static InputValues getInstance() {
    return instance;
  }

  private InputValues() {
  }

  public MWArray getInputs() {
    return inputs;
  }

  public void setInputs(MWArray inputs) {
    this.inputs = inputs;
  }

  public MWArray getExpectedOutputs() {
    return expectedOutputs;
  }

  public void setExpectedOutputs(MWArray expectedOutputs) {
    this.expectedOutputs = expectedOutputs;
  }

  public MWArray getInputsTest() {
    return inputsTest;
  }

  public void setInputsTest(MWArray inputsTest) {
    this.inputsTest = inputsTest;
  }

  public MWArray getExpectedOutputsTest() {
    return expectedOutputsTest;
  }

  public void setExpectedOutputsTest(MWArray expectedOutputsTest) {
    this.expectedOutputsTest = expectedOutputsTest;
  }
}
