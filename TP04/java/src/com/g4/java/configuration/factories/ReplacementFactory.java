package com.g4.java.configuration.factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.g4.java.selection.BoltzmannSelection;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.RuletteSelection;
import com.g4.java.selection.Selection;

public class ReplacementFactory {

	private Properties properties;
	
	public ReplacementFactory(Properties properties) {
		this.properties = properties;
	}
	
	public List<Selection> loadReplacementMethods(){
		List<Selection> replaced = new ArrayList<Selection>();
		
		String [] replacements = properties.getProperty("replacement").split("/");
		for (int i = 0; i < replacements.length; i++) {
			String replacedMethod = replacements[i].trim().toUpperCase();
			if (replacedMethod.equals(ReplacementEnum.ELITE.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Elite.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Elite.toSelect"));
				replaced.add(new EliteSelection(toSelect));
				
			} else if (replacedMethod.equals(ReplacementEnum.RULETTE.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Rulette.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Rulette.toSelect"));
				replaced.add(new RuletteSelection(toSelect));
				
			} else if (replacedMethod.equals(ReplacementEnum.BOLTZMAN.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Boltzman.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Boltzman.toSelect"));
				
				double maxTemperature = 1000;
				if( properties.getProperty("replacement.Boltzman.maxTemperature") != null ) 
					maxTemperature = Integer.valueOf(properties.getProperty("replacement.Boltzman.maxTemperature"));
				
				double minTemperature = 100;
				if( properties.getProperty("replacement.Boltzman.minTemperature") != null ) 
					minTemperature = Integer.valueOf(properties.getProperty("replacement.Boltzman.minTemperature"));
				
				double decrement = 5;
				if( properties.getProperty("replacement.Boltzman.decrement") != null ) 
					decrement = Integer.valueOf(properties.getProperty("replacement.Boltzman.decrement"));
				
				replaced.add(new BoltzmannSelection(maxTemperature, minTemperature, decrement, toSelect));
			}
		}
		return replaced;
	}

}
