function[error, error_test] = evalANN(allWeights, inputs, expected_outputs, inputs_test, expected_outputs_test, index)

	conf = globalConf;

	params = conf.getParams();
	eta = params.eta;
	alpha = params.alpha;
	momentumIsEnabled = params.momentumIsEnabled;	

	neurons_per_layer = conf.getConfiguration(index);
	numberOfLayers = length(neurons_per_layer(1,:))-1;
	activationFunctions = conf.getActivationFunction(numberOfLayers);
   
	error = test(activationFunctions(1,:), allWeights, inputs, expected_outputs);
	error_test = test(activationFunctions(1,:), allWeights, inputs_test, expected_outputs_test);
    

end



