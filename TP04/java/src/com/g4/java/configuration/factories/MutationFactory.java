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
		MutationEnum mutEnum = MutationEnum.getMutationEnum(properties.getProperty("mutation"));
		
		Mutation mutation = null;
		
		double mutationProbability = 0.1;
		if (properties.getProperty("mutationProbability") != null) {	
			mutationProbability = Double.valueOf(properties.getProperty("mutationProbability"));
		}
		switch (mutEnum) {
			case CLASSIC:
				mutation = new ClassicMutation(mutationProbability);
				break;
			case NOT_UNIFORM:
				double  decreaseConstant = 0.95;
				if (properties.getProperty("NonUniform.decreaseConstant") != null) {	
					decreaseConstant = Double.valueOf(properties.getProperty("NonUniform.decreaseConstant"));
				}
				int generationToDecrease = 10;
				if (properties.getProperty("NonUniform.generationToDecrease") != null) {	
					generationToDecrease = Integer.valueOf(properties.getProperty("NonUniform.generationToDecrease"));
				}
				mutation = new NotUniformMutation(mutationProbability, generationToDecrease, decreaseConstant);
				break;
		}
		return mutation;
	}	
}
