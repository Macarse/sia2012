package com.g4.java;

public class PlotData {
	
	public Double fitness;
	public Double worst;
	public Double median;
	
	public PlotData(double fitness, double worst, double median){
		this.fitness = new Double(fitness);
		this.worst= new Double(worst);
		this.median = new Double(median);
	}

}
