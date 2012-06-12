package com.g4.java.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.g4.java.model.Individual;

public class EliteSelection implements Selection {

  public List<Individual> select(List<Individual> population,
      final int toSelect) {
    List<Individual> ret = new ArrayList<Individual>(population);
    Collections.sort(ret, new Comparator<Individual>() {

      @Override
      public int compare(Individual i1, Individual i2) {
        final double i1Aptitude = i1.getApptitude();
        final double i2Aptitude = i2.getApptitude();

        if (i1Aptitude < i2Aptitude) {
          return 1;
        } else if (i1Aptitude > i2Aptitude) {
          return -1;
        }
        return 0;
      }
    });

    return ret.subList(0, toSelect);
  }
}
