package com.g4.java.configuration.factories;

import java.util.Properties;

import com.g4.java.mutation.ClassicMutation;
import com.g4.java.mutation.Mutation;
import com.g4.java.mutation.NotUniformMutation;

public class MutationFactory {

	private Properties properties;
	
	public MutationFactory(Properties properties) {
		this.properties = properties;
	}

	public Mutation loadMutationList (){
		MutationEnum mutEnum = MutationEnum.getMutationEnum(properties.getProperty("mutation").toUpperCase());
		
		Mutation mutation = null;
		
		double mutationProbability = 0.1;
		if (properties.getProperty("mutationProbability") != null) {	
			mutationProbability = Double.valueOf(properties.getProperty("mutationProbability"));
		}
		double  alleleProb = 0.01;
		if (properties.getProperty("Mutation.alleleProb") != null) {	
			alleleProb = Double.valueOf(properties.getProperty("Mutation.alleleProb"));
		}
		
		switch (mutEnum) {
			case CLASSIC:
				mutation = new ClassicMutation(mutationProbability, alleleProb);
				break;
			case NOT_UNIFORM:
				double  decreaseConstant = 0.95;
				if (properties.getProperty("NotUniform.decreaseConstant") != null) {	
					decreaseConstant = Double.valueOf(properties.getProperty("NotUniform.decreaseConstant"));
				}
				int generationToDecrease = 10;
				if (properties.getProperty("NotUniform.generationToDecrease") != null) {	
					generationToDecrease = Integer.valueOf(properties.getProperty("NotUniform.generationToDecrease"));
				}
				mutation = new NotUniformMutation(mutationProbability, generationToDecrease, decreaseConstant, alleleProb);
				break;
		}
		return mutation;
	}	
}
