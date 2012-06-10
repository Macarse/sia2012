package com.g4.java.mutation;


public class NotUniformMutation extends ClassicMutation {

  private int generationsToDecrease;
  private double decreaseConstant;

  public NotUniformMutation(double mutationPercentage,
      int generationsToDecrease, double decreaseConstant) {
    super(mutationPercentage);
    this.generationsToDecrease = generationsToDecrease;
    this.decreaseConstant = decreaseConstant;
  }

  @Override
  public void updateMutationProbability(int iteration) {
    if (iteration % generationsToDecrease == 0 && iteration != 0) {
      this.mutationPercentage *= decreaseConstant;
    }
  }

}

