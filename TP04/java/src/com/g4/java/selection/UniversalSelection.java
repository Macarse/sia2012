package com.g4.java.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.util.Pair;

public class UniversalSelection implements Selection {

	@Override
	public List<Individual> select(List<Individual> population, int toSelect) {
		List<Pair<Individual, Double>> aptitudes = new ArrayList<Pair<Individual,Double>>();
		
		// Total Fitness of population
		int sum = 0;
		for (Individual entity : population) {
			double ap = entity.getApptitude();
			sum += ap;
			aptitudes.add(new Pair<Individual, Double>(entity, ap));
		}
		
		
		List<Double> randoms = new ArrayList<Double>();
		double r = Math.random();
		for(int i = 0 ; i < toSelect ; ++i){
			double rj = (r + i) / toSelect;
			rj -= Math.floor(rj);
			randoms.add(rj);
		}
		
		Collections.sort(randoms);
		List<Individual> selecteds = new ArrayList<Individual>();
		
		double acum = 0;
		for(int i = 0, j = 0; i < toSelect ; ++i){
			while( j < aptitudes.size() && randoms.get(i) > acum+(aptitudes.get(j).getO2()/sum)){
				acum += aptitudes.get(j).getO2()/sum;
				j++;
			}
			selecteds.add(aptitudes.get(j).getO1());
		}
		return selecteds;

	}

}
