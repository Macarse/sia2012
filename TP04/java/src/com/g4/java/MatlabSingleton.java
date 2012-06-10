package com.g4.java;

import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWException;

public class MatlabSingleton {
	
	private static MatlabSingleton instance = null;
	private ANN ann; 
	
	public static MatlabSingleton getInstance() throws MWException{
		if (instance == null) {
			instance = new MatlabSingleton();
		}
		return instance;
	}
	
	public MatlabSingleton() throws MWException {
		ann = new ANN();
	}

	public ANN getAnn() {
		return ann;
	}

}
