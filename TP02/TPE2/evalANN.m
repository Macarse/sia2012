function[error, error_test] = evalANN(allWeights, inputs, expected_outputs, inputs_test, expected_outputs_test)

%%%%% PARAMETERS DEFINED %%%%%

N = 2;

constant_seed();

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

%%%%% PROBLEM SOLVER %%%%%

prevError = 0;

error = 1;

curK = 0;

neurons_per_layer = [N neurons_per_layer];

numberOfLayers = length(neurons_per_layer(1,:))-1;

activationFunctions = cell(2, numberOfLayers);

activationFunctions(1,numberOfLayers) = {lineal_function};
activationFunctions(2,numberOfLayers) = {lineal_function_deriv};

for i = 1:numberOfLayers-1
   activationFunctions(1,i) = {g};
   activationFunctions(2,i) = {g_deriv};
end
   
error = test(activationFunctions(1,:), allWeights, inputs, expected_outputs);
error_test = test(activationFunctions(1,:), allWeights, inputs_test, expected_outputs_test);
    

end



