package com.g4.java.model;

import java.util.ArrayList;
import java.util.List;

import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWClassID;
import com.mathworks.toolbox.javabuilder.MWNumericArray;

public class Individual {

  private MWCellArray data;
  private double apptitude;

  public Individual() {
  }

  public MWCellArray getData() {
    return data;
  }

  public void setData(MWCellArray data) {
    this.data = data;
  }

  public double getApptitude() {
    return 1 / apptitude;
  }

  public void setApptitude(double apptitude) {
    this.apptitude = apptitude;
  }

  public List<double[][]> getLupusMatrix() {
    List<double[][]> ret = new ArrayList<double[][]>();

    for ( int i = 1 ; i <= data.numberOfElements() ; i++ ) {
      MWNumericArray matrix = (MWNumericArray) data.getCell(i);
      double[][] doubleMatrix = (double[][]) matrix.toArray();
      ret.add(doubleMatrix);
    }

    return ret;
  }

  public double[] getLupusArray() {
    int size = 0;
    for ( int i = 1 ; i <= data.numberOfElements() ; i++ ) {
      MWArray matrix = (MWArray) data.getCell(i);
      int[] dim = matrix.getDimensions();
      size += dim[0] * dim[1];
    }

    double[] ret = new double[size];
    int index = 0;

    for ( int i = 1 ; i <= data.numberOfElements() ; i++ ) {
      MWNumericArray matrix = (MWNumericArray) data.getCell(i);

      double[][] doubleMatrix = (double[][]) matrix.toArray();
      for (int j = 0; j < doubleMatrix.length; j++) {
        for (int k = 0; k < doubleMatrix[j].length; k++) {
          ret[index++] = doubleMatrix[j][k];
        }
      }

      matrix.dispose();
    }

    return ret;
  }

  public static Individual creator(MWCellArray cellArray, double[] values) {
    Individual ret = new Individual();
    MWCellArray data = new MWCellArray(cellArray.numberOfElements(), 1);
    int index = 0;

    for(int i = 1 ; i <= cellArray.numberOfElements() ; i++ ) {
      MWNumericArray matrix = (MWNumericArray) cellArray.getCell(i);
      int[] dim = matrix.getDimensions();
      double[][] createdMatrix = new double[dim[0]][dim[1]];

      for( int j = 0 ; j < dim[0] ; j++ ) {
        for (int k = 0; k < dim[1]; k++) {
          createdMatrix[j][k] = values[index++];
        }
      }
      
      data.set(i, new MWNumericArray(createdMatrix, MWClassID.DOUBLE));
    }

    ret.setData(data);
    return ret;
  }
  
}
