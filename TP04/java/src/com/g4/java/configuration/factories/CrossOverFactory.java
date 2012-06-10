package com.g4.java.configuration.factories;

import java.util.Properties;

import com.g4.java.crossover.AnularCrossover;
import com.g4.java.crossover.Crossover;
import com.g4.java.crossover.GeneCrossOver;
import com.g4.java.crossover.MultipleCrossOver;
import com.g4.java.crossover.ParameterizedUniformCrossOver;
import com.g4.java.crossover.SinglePointCrossOver;

public class CrossOverFactory {

	private Properties properties;

	public CrossOverFactory(Properties properties) {
		this.properties = properties;
	}

	public Crossover loadCrossOver() {
		Crossover crossover = null;
		CrossOverEnum crossEnum = CrossOverEnum.getCrossOverEnum(properties
				.getProperty("crossover"));
		
		switch (crossEnum) {
			case ANULAR:
				crossover = new AnularCrossover();
				break;
			case MULTIPLE_POINT:
				int cutPointsQty = 1;
				if (properties.getProperty("MultiplePoint.cutPoints") != null) {
					cutPointsQty = Integer.valueOf(properties
							.getProperty("MultiplePoint.cutPoints"));
				}
				crossover = new MultipleCrossOver(cutPointsQty);
				break;
			case UNIFORM:
				double segmentedProb = 1;
				if (properties.getProperty("Uniform.probability") != null) {
					segmentedProb = Double.valueOf(properties
							.getProperty("Uniform.probability"));
				}
				crossover = new ParameterizedUniformCrossOver(segmentedProb);
				break;
			case CLASSIC:
				crossover = new SinglePointCrossOver();
				break;
			case GENE:
				crossover = new GeneCrossOver();
				break;
			}

		return crossover;
	}

}
