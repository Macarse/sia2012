package com.g4.java.configuration.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.g4.java.configuration.RepresentationEnum;
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
	
	public List<Crossover> loadCrossOver(){
		String[] crossOvers = properties.getProperty("crossover").trim().split("/");
		List<Crossover> crossoversList = new ArrayList<Crossover>();
		
		for (int i = 0; i < crossOvers.length; i++) {
			CrossOverEnum crossEnum = CrossOverEnum.getCrossOverEnum(crossOvers[i]
		                                                           .trim()
		                                                           .toUpperCase());
			switch (crossEnum) {
			case ANULAR:
				crossoversList.add(new AnularCrossover());
				break;
			case MULTIPLE_POINT:
				int cutPointsQty = 1;
				if (properties.getProperty("MultiplePoint.cutPoints") != null ) {
					cutPointsQty = Integer.valueOf(properties.getProperty("MultiplePoint.cutPoints"));
				}
				crossoversList.add(new MultipleCrossOver(cutPointsQty ));
				break;
			case UNIFORM:
				double segmentedProb = 1;
				if (properties.getProperty("Segmented.probability") != null ) {
					segmentedProb = Double.valueOf(properties.getProperty("Segmented.probability"));
				}
				crossoversList.add(new ParameterizedUniformCrossOver(segmentedProb));
				break;
			case CLASSIC:
				crossoversList.add(new SinglePointCrossOver());
				break;
			case GENE:
				crossoversList.add(new GeneCrossOver());
				break;
			}
		}
		
		return crossoversList;
	}

}
