package com.g4.java;

import com.mathworks.toolbox.javabuilder.MWArray;

public class Individual {

  private MWArray data;
  private double apptitude;

  public Individual() {
  }

  public MWArray getData() {
    return data;
  }

  public void setData(MWArray data) {
    this.data = data;
  }

  public double getApptitude() {
    return apptitude;
  }

  public void setApptitude(double apptitude) {
    this.apptitude = apptitude;
  }

}
