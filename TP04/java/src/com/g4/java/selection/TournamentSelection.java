package com.g4.java.selection;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;

public class TournamentSelection implements Selection {

  private int tSize;
  private int toSelect;

  public TournamentSelection(int tSize, final int toSelect) {
    this.tSize = tSize;
    this.toSelect = toSelect;
  }

  @Override
  public List<Individual> select(List<Individual> population, int generation) {
    List<Individual> selected = new ArrayList<Individual>(toSelect);

    for (int i = 0; i < toSelect; ++i) {
      double bestAptitude = Double.NEGATIVE_INFINITY;
      Individual auxEntity = null;

      for (int j = 0; j < tSize; ++j) {
        int index = (int) Math.floor(Math.random() * (population.size()));
        double curAptitude = population.get(index).getApptitude();
        if (curAptitude > bestAptitude) {
          auxEntity = population.get(index);
          bestAptitude = curAptitude;
        }
      }

      if (auxEntity != null) {
        selected.add(auxEntity);
      }
    }

    return selected;
  }
}
