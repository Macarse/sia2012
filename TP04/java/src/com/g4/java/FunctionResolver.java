package com.g4.java;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.g4.java.configuration.Configuration;
import com.g4.java.crossover.Crossover;
import com.g4.java.ending.EndingMethod;
import com.g4.java.model.Individual;
import com.g4.java.mutation.Mutation;
import com.g4.java.reproduction.MonogamousReproduction;
import com.g4.java.reproduction.Reproduction;
import com.g4.java.selection.EliteSelection;
import com.g4.java.selection.MixSelection;
import com.g4.java.selection.Selection;
import com.g4.java.util.InputValues;
import com.g4.matlab.ann.ANN;
import com.mathworks.toolbox.javabuilder.MWArray;
import com.mathworks.toolbox.javabuilder.MWCellArray;
import com.mathworks.toolbox.javabuilder.MWException;

public class FunctionResolver {

  public static final int ARCHITECTURE = 2;
	private static final int POP_SIZE = 52;

	private Configuration configuration;
	
	private MixSelection selection;
	private Mutation mutation;
	private Crossover crossover;
	private Reproduction reproduction = new MonogamousReproduction();
	private EndingMethod ending;
	private Backpropagation backpropagation;
	private Selection replacement; 
	
	private List<Individual> population = new ArrayList<Individual>(POP_SIZE);
	
	private ANN ann;

	public static void main(String[] args) throws FileNotFoundException, IOException, MWException {
		FunctionResolver resolver = new FunctionResolver();
		
		resolver.configuration = new Configuration(args[0]);
		
		resolver.selection = new MixSelection(resolver.configuration.getSelectionMethods());
		resolver.mutation = resolver.configuration.getMutation();
		resolver.crossover = resolver.configuration.getCrossOverMethods();
		resolver.ending = resolver.configuration.getEnding();
		resolver.backpropagation = resolver.configuration.getBackpropagation();
		resolver.replacement = new MixSelection(resolver.configuration.getReplacementMethods());
		resolver.ann = MatlabSingleton.getInstance().getAnn();
		
		try {
			resolver.run();
		} catch (MWException e) {
			System.err.println(e.getCause());
			System.exit(0);
		}
	}

	private void run() throws MWException {
		// Create the input values based on samples3.txt
		Object[] inputResult = ann.generateInputFromFile(4, "samples3.txt",
				.80f, 0);
		InputValues.getInstance().setInputs((MWArray) inputResult[0]);
		InputValues.getInstance().setExpectedOutputs((MWArray) inputResult[1]);
		InputValues.getInstance().setInputsTest((MWArray) inputResult[2]);
		InputValues.getInstance().setExpectedOutputsTest(
				(MWArray) inputResult[3]);

		// Create the evaluation function.
		Function function = new Function(ann);
		long creationStartTime = System.currentTimeMillis();

		// Create the initial population
		for (int i = 0; i < POP_SIZE; i++) {
			Individual individual = new Individual();
			Object[] createIndividualResult = ann.createIndividual(1,
					InputValues.getInstance().getInputs(), InputValues
							.getInstance().getExpectedOutputs(), InputValues
							.getInstance().getInputsTest(), InputValues
							.getInstance().getExpectedOutputsTest(), ARCHITECTURE);

			individual.setData((MWCellArray) createIndividualResult[0]);
			population.add(individual);
		}

		// Calculate the aptitude for every individual.
		for (int i = 0; i < POP_SIZE; i++) {
			population.get(i).setApptitude(function.eval(population.get(i)));
		}

		System.out.println("Whole creation process took: "
				+ (System.currentTimeMillis() - creationStartTime));

		for (int i = 0; !ending.shouldEnd(population, i) ; i++) {
		  mutation.updateMutationProbability(i);

			List<Individual> best = selection.select(population, i);
			List<Individual[]> parents = reproduction.getParents(best);
			List<Individual> generation = new ArrayList<Individual>();
			List<Individual> sons = new ArrayList<Individual>();

			for (Individual[] family : parents) {
				generation.add(family[0]);
				generation.add(family[1]);

				if ( crossover.shouldApply() ) {
				  Individual[] childs = crossover.cross(family);
	        sons.add(childs[0]);
	        sons.add(childs[1]);
				} else {
				  sons.add(family[0]);
          sons.add(family[1]);
				}
			}

			List<Individual> sonsToAdd = new ArrayList<Individual>();
			for (Individual individual : sons) {
			  Individual individualToAdd = individual;

				if (mutation.shouldMutate()) {
				  System.out.println("Mutation started");
				  individualToAdd = mutation.mutate(individualToAdd, i);
					System.out.println("Mutation ended");
				}

				if ( backpropagation.shouldApply() ) {
				  System.out.println("Backpropagation started");
				  individualToAdd = backpropagation.run(individualToAdd);
					System.out.println("Backpropagation ended");
				}

				sonsToAdd.add(individualToAdd);
			}

			sons.clear();
			sons = null;

			generation.addAll(sonsToAdd);

			for (Individual individual : sonsToAdd) {
				individual.setApptitude(function.eval(individual));
			}
			
			population = replacement.select(generation, i);

			EliteSelection bestSel = new EliteSelection(1);
			System.out.println("Best individual (Apptitude) " + bestSel.select(population, i).get(0).getApptitude());
			System.out.println("Worst individual (Apptitude) " + population.get(POP_SIZE-1).getApptitude());
			System.out.println("Finish Generation " + i);
		}

	}
}
