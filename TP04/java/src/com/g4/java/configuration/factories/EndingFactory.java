package com.g4.java.configuration.factories;

import java.util.Properties;

import com.g4.java.ending.ContentEnding;
import com.g4.java.ending.EndingMethod;
import com.g4.java.ending.MaxGenerationEnding;
import com.g4.java.ending.OptimumOrFitnessEnding;
import com.g4.java.ending.StructuralEnding;

public class EndingFactory {

	private Properties properties;

	public EndingFactory(Properties properties) {
		this.properties = properties;
	}

	public EndingMethod loadEnding() {

		EndingMethod ending = null;
		EndingEnum endingEnum = EndingEnum.getEndingEnum(properties
				.getProperty("ending").toUpperCase());
		switch (endingEnum) {
			case CONTENT:
				double improvement = 1;
				if (properties.getProperty("Content.improvement") != null) {
					improvement = Double.valueOf(properties
							.getProperty("Content.improvement"));
				}
				int iterationsToImprove = 1;
				if (properties.getProperty("Content.iterationToImprove") != null) {
					iterationsToImprove = Integer.valueOf(properties
							.getProperty("Content.iterationToImprove"));
				}
				ending = new ContentEnding(iterationsToImprove, improvement);
				break;
			case MAXGENERATION:
				int iterationsToEnd = 1;
				if (properties.getProperty("MaxGeneration.iterationToEnd") != null) {
					iterationsToEnd = Integer.valueOf(properties
							.getProperty("MaxGeneration.iterationToEnd"));
				}
				ending = new MaxGenerationEnding(iterationsToEnd);
				break;
			case OPTIMUM:
				double optimum = 1;
				if (properties.getProperty("Optimum.optimum") != null) {
					optimum = Double.valueOf(properties
							.getProperty("Optimum.optimum"));
				}
				double tolerance = 1;
				if (properties.getProperty("Optimum.tolerance") != null) {
					tolerance = Double.valueOf(properties
							.getProperty("Optimum.tolerance"));
				}
				ending = new OptimumOrFitnessEnding(optimum, tolerance);
				break;
			case STRUCTURAL:
				int iterationsToCheck = 1;
				if (properties.getProperty("Structural.iterationsToCheck") != null) {
					iterationsToCheck = Integer.valueOf(properties
							.getProperty("Structural.iterationsToCheck"));
				}
				int percent = 1;
				if (properties.getProperty("Structural.iterationToEnd") != null) {
					percent = Integer.valueOf(properties
							.getProperty("Structural.iterationToEnd"));
				}
				int popSize = 1;
				if (properties.getProperty("Structural.popSize") != null) {
					popSize = Integer.valueOf(properties
							.getProperty("Structural.popSize"));
				}
				ending = new StructuralEnding(iterationsToCheck, percent, popSize);
				break;
		}

		return ending;
	}

}
