package com.g4.java.ending;

import java.util.List;

import com.g4.java.model.Individual;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.Selection;

public class StructuralEnding implements EndingMethod {

	private int iterationsToCheck;
	private int toBeEqual;
	private Selection elite;
	
	public StructuralEnding(int iterationsToCheck, int percent, int popSize) {
		this.iterationsToCheck = iterationsToCheck;
		this.toBeEqual = (popSize*percent)/100;
		this.elite = new EliteSelection();
	}
	
	@Override
	public boolean shouldEnd(List<Individual> population, int iterations) {
		if(iterations % iterationsToCheck != 0){
			return false;
		}
		
		List<Individual> bests = elite.select(population, this.toBeEqual);
		
		for (Individual ind : bests) {
			if(bests.get(0).getApptitude() != ind.getApptitude()){
				return false;
			}
		}
		return true;
	}

}
