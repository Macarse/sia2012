package com.g4.java.configuration.factories;

import java.util.Properties;

import com.g4.java.Backpropagation;
import com.g4.java.MatlabSingleton;
import com.mathworks.toolbox.javabuilder.MWException;

public class BackpropagationFactory {

	private Properties properties;
	
	public BackpropagationFactory(Properties properties) {
		this.properties = properties;
	}
	
	public Backpropagation loadBackpropagation() throws MWException{
		double prob = 0;
		if (properties.getProperty("Backpropagation.probability") != null) {	
			prob = Double.valueOf(properties.getProperty("Backpropagation.probability"));
		}
		
		int iterations = 30;
		if (properties.getProperty("Backpropagation.iterations") != null) {	
			iterations = Integer.valueOf(properties.getProperty("Backpropagation.iterations"));
		}

		return new Backpropagation(MatlabSingleton.getInstance().getAnn(), iterations, prob);
	}
}

