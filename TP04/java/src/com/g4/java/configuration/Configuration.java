package com.g4.java.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.g4.java.configuration.factories.CrossOverFactory;
import com.g4.java.configuration.factories.EndingFactory;
import com.g4.java.configuration.factories.MutationFactory;
import com.g4.java.configuration.factories.ReplacementFactory;
import com.g4.java.configuration.factories.SelectionFactory;
import com.g4.java.crossover.Crossover;
import com.g4.java.ending.EndingMethod;
import com.g4.java.mutation.Mutation;
import com.g4.java.selection.Selection;

public class Configuration {
	
	private Properties properties;
	
	private boolean hasToMaximize;
	private boolean hasToDraw;
	private List<EndingMethod> endingMethods;

	private Mutation mutation;

	private List<Selection> selectionMethods;
	
	private List<Replacement> replacementMethods;
	private boolean replacementByPopulation = false;
	
	private List<Crossover> crossOverMethods;

	private MutationFactory mutationFactory;
	private SelectionFactory selectionFactory;
	private ReplacementFactory replacementFactory;
	private CrossOverFactory crossOverFactory;
	private EndingFactory endingFactory;
	
	public Configuration(String propertiesPath) throws FileNotFoundException, IOException {
		this.properties = new Properties();
		this.mutationFactory = new MutationFactory(this.properties);
		this.selectionFactory = new SelectionFactory(this.properties);
		this.replacementFactory = new ReplacementFactory(this.properties);
		this.crossOverFactory = new CrossOverFactory(this.properties);
		this.endingFactory = new EndingFactory(this.properties);
		
		this.properties.load(new FileInputStream(System.getProperty("user.dir") + 
				propertiesPath));

		loadGeneralData();
		loadMutationData();
		loadSelectionData();
		loadReplacementData();
		loadCrossOverData();
		loadEndingData();
	}
	
	private void loadEndingData() {
		this.endingMethods = this.endingFactory.loadEndingMethods();
	}

	private void loadCrossOverData() {
		this.crossOverMethods = this.crossOverFactory.loadCrossOver();
	}

	private void loadReplacementData() {
		if (properties.getProperty("replacementOnlySuns") != null) {
			this.replacementByPopulation = Boolean.valueOf(properties.getProperty("replacementOnlySuns"));
		} else {
			this.replacementByPopulation = false;
		}
		this.replacementMethods = this.replacementFactory.loadReplacementMethods();
	}

	private void loadSelectionData() {
		this.selectionMethods = this.selectionFactory.loadSelectionMethods();
	}

	private void loadMutationData() {
		this.mutation = this.mutationFactory.loadMutationList();
	}

	private void loadGeneralData() {
		this.hasToDraw = Boolean.valueOf(properties.getProperty("hasToDraw"));
		this.hasToMaximize = Boolean.valueOf(properties.getProperty("hasToMaximize"));
	}

	public boolean isHasToDraw() {
		return hasToDraw;
	}

	public Mutation getMutation() {
		return mutation;
	}
	
	public boolean isHasToMaximize() {
		return hasToMaximize;
	}
	
	public List<Selection> getSelectionMethods() {
		return selectionMethods;
	}
	
	public List<Replacement> getReplacementMethods() {
		return replacementMethods;
	}
	
	public boolean isReplacementByPopulation() {
		return replacementByPopulation;
	}

	public List<Crossover> getCrossOverMethods() {
		return crossOverMethods;
	}

	public List<EndingMethod> getEndingMethods() {
		return endingMethods;
	}
	
	public boolean replacementIsOnlySuns(){
		return replacementByPopulation;
	}
	
}
