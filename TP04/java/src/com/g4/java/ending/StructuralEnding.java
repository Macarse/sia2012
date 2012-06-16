package com.g4.java.ending;

import java.util.ArrayList;
import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.Selection;

public class StructuralEnding implements EndingMethod {

	private int iterationsToCheck;
	private int toBeEqual;
	private Selection elite;
	private List<List<Individual>> lastIndividuals;
	
	public StructuralEnding(int iterationsToCheck, int percent, int popSize) {
		this.iterationsToCheck = iterationsToCheck;
		this.toBeEqual = (popSize*percent)/100;
		this.elite = new EliteSelection(this.toBeEqual);
		this.lastIndividuals = new ArrayList<List<Individual>>();
	}
	
	@Override
	public boolean shouldEnd(List<Individual> population, int iterations) {
		if(iterations % iterationsToCheck != 0 || iterations == 0){
			lastIndividuals.add(population);
			return false;
		}
		
		List<List<Individual>> bests = new ArrayList<List<Individual>>();
		for (List<Individual> list : lastIndividuals) {
			bests.add(elite.select(list, 0));
		}
		
		boolean ret = false;
		for (int i = 0 ; i < this.toBeEqual ; i++) {
			double firstApp = bests.get(0).get(i).getApptitude();
			double lastApp = bests.get(bests.size()-1).get(i).getApptitude();
			ret |= (firstApp == lastApp);
		}
		
		return ret;
	}

}
