%% backpropagation: function description
function [outputs] = backpropagation(allWeights, inputs, expected_outputs, iterations, index)
	
	conf = globalConf;

	params = conf.getParams();
	eta = params.eta;
	alpha = params.alpha;
	momentumIsEnabled = params.momentumIsEnabled;	

	neurons_per_layer = conf.getConfiguration(index);
	numberOfLayers = length(neurons_per_layer(1,:))-1;
	activationFunctions = conf.getActivationFunction(numberOfLayers);

	rounds = 0;
	while rounds < iterations
		allWeights = train( activationFunctions(1,:), activationFunctions(2,:), allWeights, inputs, expected_outputs, eta, momentumIsEnabled, alpha );
		rounds = rounds + 1;
	end

	outputs = allWeights;

end