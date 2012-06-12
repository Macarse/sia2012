package com.g4.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EliteSelection {


  public EliteSelection() {
  }

  public List<Individual> select(List<Individual> parents, final int toSelect) {
    List<Individual> ret = new ArrayList<Individual>(parents);
    Collections.sort(ret, new Comparator<Individual>() {

      @Override
      public int compare(Individual i1, Individual i2) {
        return -1;
      }
    });
    
    return ret.subList(0, toSelect);
  }
}
