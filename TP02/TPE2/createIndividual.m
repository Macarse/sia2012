function [ allWeights ] = createIndividual(inputs, expected_outputs, inputs_test, expected_outputs_test, index)

	conf = globalConf;

	params = conf.getParams();
	eta = params.eta;
	alpha = params.alpha;
	momentumIsEnabled = params.momentumIsEnabled;	

	neurons_per_layer = conf.getConfiguration(index);
	allWeights = generateWeights(neurons_per_layer);
	numberOfLayers = length(neurons_per_layer(1,:))-1;
	activationFunctions = conf.getActivationFunction(numberOfLayers);


	allWeights = train( activationFunctions(1,:), activationFunctions(2,:), allWeights, inputs, expected_outputs, eta, momentumIsEnabled, alpha );

end