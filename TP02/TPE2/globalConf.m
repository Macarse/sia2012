%% globalConf: description
function [outputs] = globalConf()
	outputs.getConfiguration = @getConfiguration;
	outputs.getActivationFunction = @getActivationFunction;
	outputs.getParams = @getParams;
end

function [configuration] = getConfiguration(index)
	N = 2;
	neurons_per_layer_array = cell(7, 1);
	neurons_per_layer_array{1} = [30 20 10 1];
	neurons_per_layer_array{2} = [10 10 1];
	neurons_per_layer_array{3} = [10 1];
	neurons_per_layer_array{4} = [10 10 10 10 1];
	neurons_per_layer_array{5} = [40 20 1];
	neurons_per_layer_array{6} = [10 10 10 1];
	neurons_per_layer_array{7} = [5 10 20 1];

	configuration = [N neurons_per_layer_array{index}];
end

function [funcs] = getActivationFunction(numberOfLayers)

	g = @no_lineal_exp;
	g_deriv = @no_lineal_deriv_exp;

	lineal_function = @lineal;
	lineal_function_deriv = @lineal_deriv;

	funcs = cell(2, numberOfLayers);
	funcs(1,numberOfLayers) = {lineal_function};
	funcs(2,numberOfLayers) = {lineal_function_deriv};

	for i = 1:numberOfLayers-1
	   funcs(1,i) = {g};
	   funcs(2,i) = {g_deriv};
	end

end

function [params] = getParams()

	params.eta = 0.4;
	params.momentumIsEnabled = 1;
	params.alpha = 0.2;

end


