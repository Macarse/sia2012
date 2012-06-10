package com.g4.java.configuration.factories;

import java.util.ArrayList;
import java.util.List;
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

	public List<EndingMethod> loadEndingMethods() {
		List<EndingMethod> lists = new ArrayList<EndingMethod>();
		String[] endings = properties.getProperty("endings").split("/");
		for (int i = 0; i < endings.length; i++) {
			EndingEnum endingEnum = EndingEnum.getEndingEnum(endings[i].trim());
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
				lists.add(new ContentEnding(iterationsToImprove, improvement));
				break;
			case MAXGENERATION:
				int iterationsToEnd = 1;
				if (properties.getProperty("MaxGeneration.iterationToEnd") != null) {
					iterationsToEnd = Integer.valueOf(properties
							.getProperty("MaxGeneration.iterationToEnd"));
				}
				lists.add(new MaxGenerationEnding(iterationsToEnd));
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
				lists.add(new OptimumOrFitnessEnding(optimum, tolerance));
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
				lists.add(new StructuralEnding(iterationsToCheck, percent, popSize));
				break;
			}
		}

		return lists;
	}

}
