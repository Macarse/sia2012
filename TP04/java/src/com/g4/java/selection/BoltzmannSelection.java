package com.g4.java.selection;

import java.util.List;

import com.g4.java.model.Individual;

public class BoltzmannSelection extends RuletteSelection {

	private double temperature;
	private double varInTime;
	private final double maxTemperature;
	private final double minTemperature;
	private final double decrement;

	public BoltzmannSelection(final double maxTemperature, 
			final double minTemperature, 
			final double decrement) {
		this.maxTemperature = maxTemperature;
		this.minTemperature = minTemperature;
		this.decrement = decrement;
	}

	/**
	 * Returns a fitness based on the Boltzmann theorem
	 */
	
	@Override
	public double filterFitness(double fitness) {
		return Math.exp(fitness / temperature) / this.varInTime;
	}
	
	@Override
	public List<Individual> select(List<Individual> population, int toSelect, int generation) {
		calculateTemperature(generation);
		this.varInTime = 0;
		for (Individual ind : population) {
			this.varInTime += Math.exp(ind.getApptitude()/this.temperature);
		}
		return super.select(population, toSelect, generation);
	}

	private void calculateTemperature(int generation) {
		this.temperature = maxTemperature - generation * this.decrement;
		if (this.temperature < this.minTemperature) {
			this.temperature = this.minTemperature;
		}
	}
}
