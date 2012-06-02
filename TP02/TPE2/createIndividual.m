function [ allWeights ] = createIndividual(inputs, expected_outputs, inputs_test, expected_outputs_test)

N = 2;

neurons_per_layer = [30 20 10 1];

eta = 0.4;

epsilon  = 0.01;

g = @no_lineal_exp;

g_deriv = @no_lineal_deriv_exp;

lineal_function = @lineal;

lineal_function_deriv = @lineal_deriv;

M = 351;

etaDecrement = 0.01;

etaIncrement = 0.1;

k = 5;

etaAdapIsEnabled = 1;

momentumIsEnabled = 1;

func = @evaluation_function;

func_deriv = @evaluation_function_deriv;

alpha = 0.2;
neurons_per_layer = [N neurons_per_layer];

numberOfLayers = length(neurons_per_layer(1,:))-1;

allWeights = generateWeights(neurons_per_layer);

activationFunctions = cell(2, numberOfLayers);
activationFunctions(1,numberOfLayers) = {lineal_function};
activationFunctions(2,numberOfLayers) = {lineal_function_deriv};

for i = 1:numberOfLayers-1
   activationFunctions(1,i) = {g};
   activationFunctions(2,i) = {g_deriv};
end


allWeights = train( activationFunctions(1,:), activationFunctions(2,:), allWeights, inputs, expected_outputs, eta, momentumIsEnabled, alpha );


end