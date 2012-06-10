package com.g4.java.configuration.factories;

import grupo10.ga.aptitude.AptitudeMethod;
import grupo10.ga.selectionmethod.ReplacementMethod;
import grupo10.ga.selectionmethod.impl.EliteSelection;
import grupo10.ga.selectionmethod.impl.RuletteSelection;
import grupo10.ga.selectionmethod.impl.TournamentSelection;
import grupo10.ga.selectionmethod.impl.UniversalSelection;

import java.util.List;
import java.util.Properties;

import com.google.common.collect.Lists;

public class ReplacementFactory {

	private Properties properties;
	
	public ReplacementFactory(Properties properties) {
		this.properties = properties;
	}
	
	public List<ReplacementMethod> loadReplacementMethods(AptitudeMethod aptitude){
		List<ReplacementMethod> replaced = Lists.newArrayList();
		
		String [] replacements = properties.getProperty("replacement").split("/");
		for (int i = 0; i < replacements.length; i++) {
			String replacedMethod = replacements[i].trim().toUpperCase();
			if (replacedMethod.equals(ReplacementEnum.ELITE.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Elite.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Elite.toSelect"));
				replaced.add(new EliteSelection(aptitude, toSelect));
				
			} else if (replacedMethod.equals(ReplacementEnum.RULETTE.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Rulette.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Rulette.toSelect"));
				replaced.add(new RuletteSelection(aptitude, toSelect));
				
			} else if (replacedMethod.equals(ReplacementEnum.TOURNAMENT.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Tournament.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Tournament.toSelect"));
				int tSize = 1;
				if( properties.getProperty("replacement.Tournament.tSize") != null ) 
					tSize = Integer.valueOf(properties.getProperty("replacement.Tournament.tSize"));
				replaced.add(new TournamentSelection(aptitude, toSelect, tSize));
				
			} else if (replacedMethod.equals(ReplacementEnum.UNIVERSAL.getName())) {
				int toSelect = 1;
				if( properties.getProperty("replacement.Universal.toSelect") != null ) 
					toSelect = Integer.valueOf(properties.getProperty("replacement.Universal.toSelect"));
				replaced.add(new UniversalSelection(aptitude, toSelect));
			}
		}
		return replaced;
	}

}
