package com.g4.java.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.g4.java.model.Individual;
import com.g4.java.util.Pair;

public class RuletteSelection implements Selection {

  @Override
  public List<Individual> select(List<Individual> population,
      int toSelect) {
    List<Pair<Individual, Double>> aptitudes = new ArrayList<Pair<Individual, Double>>();
    double sum = 0;

    for (Individual entity : population) {
      double ap = entity.getApptitude();
      sum += ap;
      aptitudes.add(new Pair<Individual, Double>(entity, ap));
    }

    List<Double> randoms = new ArrayList<Double>(toSelect);
    for (int i = 0; i < toSelect; ++i) {
      randoms.add(Math.random());
    }
    Collections.sort(randoms);

    List<Individual> selected = new ArrayList<Individual>(toSelect);
    double acum = 0;
    for (int i = 0, j = 0; i < toSelect; ++i) {
      while (j < aptitudes.size()
          && randoms.get(i) > acum + (aptitudes.get(j).getO2() / sum)) {
        acum += aptitudes.get(j).getO2() / sum;
        j++;
      }

      selected.add(aptitudes.get(j).getO1());
    }

    return selected;
  }
}
