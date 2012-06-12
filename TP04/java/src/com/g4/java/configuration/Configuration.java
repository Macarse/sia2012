package com.g4.java.configuration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.g4.java.Backpropagation;
import com.g4.java.configuration.factories.BackpropagationFactory;
import com.g4.java.configuration.factories.CrossOverFactory;
import com.g4.java.configuration.factories.EndingFactory;
import com.g4.java.configuration.factories.MutationFactory;
import com.g4.java.configuration.factories.ReplacementFactory;
import com.g4.java.configuration.factories.SelectionFactory;
import com.g4.java.crossover.Crossover;
import com.g4.java.ending.EndingMethod;
import com.g4.java.mutation.Mutation;
import com.g4.java.selection.Selection;
import com.mathworks.toolbox.javabuilder.MWException;

public class Configuration {

	private Properties properties;

	private int architecture;
	private int popSize;
	private double generationGap;

	private EndingMethod ending;

	private Mutation mutation;
	private Backpropagation backpropagation;

	private List<Selection> selectionMethods;

	private List<Selection> replacementMethods;

	private Crossover crossOver;

	private MutationFactory mutationFactory;
	private SelectionFactory selectionFactory;
	private ReplacementFactory replacementFactory;
	private CrossOverFactory crossOverFactory;
	private EndingFactory endingFactory;
	private BackpropagationFactory backpropagationFactory;

	public Configuration(String propertiesPath) throws FileNotFoundException,
			IOException, MWException {
		this.properties = new Properties();
		this.mutationFactory = new MutationFactory(this.properties);
		this.selectionFactory = new SelectionFactory(this.properties);
		this.replacementFactory = new ReplacementFactory(this.properties);
		this.crossOverFactory = new CrossOverFactory(this.properties);
		this.endingFactory = new EndingFactory(this.properties);
		this.backpropagationFactory = new BackpropagationFactory(
				this.properties);

		this.properties.load(new FileInputStream(System.getProperty("user.dir")
				+ propertiesPath));

		loadGeneralData();
		loadMutationData();
		loadBackpropagationData();
		loadSelectionData();
		loadReplacementData();
		loadCrossOverData();
		loadEndingData();
	}

	private void loadGeneralData() {
		this.architecture = Integer.valueOf(this.properties
				.getProperty("architecture"));
		this.popSize = Integer.valueOf(this.properties.getProperty("popSize"));
		this.generationGap = Double.valueOf(this.properties
				.getProperty("generationGap"));
	}

	private void loadBackpropagationData() throws MWException {
		this.backpropagation = this.backpropagationFactory
				.loadBackpropagation();
	}

	private void loadEndingData() {
		this.ending = this.endingFactory.loadEnding();
	}

	private void loadCrossOverData() {
		this.crossOver = this.crossOverFactory.loadCrossOver();
	}

	private void loadReplacementData() {
		this.replacementMethods = this.replacementFactory
				.loadReplacementMethods();
	}

	private void loadSelectionData() {
		this.selectionMethods = this.selectionFactory.loadSelectionMethods();
	}

	private void loadMutationData() {
		this.mutation = this.mutationFactory.loadMutationList();
	}

	public Mutation getMutation() {
		return mutation;
	}

	public Backpropagation getBackpropagation() {
		return backpropagation;
	}

	public List<Selection> getSelectionMethods() {
		return selectionMethods;
	}

	public List<Selection> getReplacementMethods() {
		return replacementMethods;
	}

	public Crossover getCrossOverMethods() {
		return crossOver;
	}

	public EndingMethod getEnding() {
		return ending;
	}

	public int getArchitecture() {
		return architecture;
	}

	public int getPopSize() {
		return popSize;
	}

	public double getGenerationGap() {
		return generationGap;
	}

}
