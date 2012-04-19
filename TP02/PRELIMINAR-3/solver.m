
function [ err ] = solver( g , g_deriv, N,input_gen ,epsilon, eta )

%%%%% PARAMETERS DEFINED %%%%%

constant_seed();


% Neuronas en las capas ocultas:
%   Paridad: [N 1]
%   Simetria: [N 1]
%   Xor: [N+1 1]

neurons_per_layer = [N 1];


M = 15000;

func = @evaluation_function;

func_deriv = @evaluation_function_deriv;

%%%%% PROBLEM SOLVER %%%%%

prevError = 0;

error = 1;

neurons_per_layer = [N neurons_per_layer];

numberOfLayers = length(neurons_per_layer(1,:))-1;

allWeights = generateWeights(neurons_per_layer);  

% Cell de NxM donde N = #neuronas en capa i y M = #neuronas+1 (por el bias) en la capa i-1
lastWeights = allWeights;

[inputs, expected_outputs] = input_gen(N);

% ------------------------------------------------------------------------
%Funcion de activación para cada capa.
activationFunctions = cell(2, numberOfLayers);


for i = 1:numberOfLayers
   activationFunctions(1,i) = {g};
   activationFunctions(2,i) = {g_deriv};
end
% ------------------------------------------------------------------------

debug = 0;

errors = zeros(1,1);

min_error = 50000;

while (error > epsilon && debug < M) 
    
    allWeights = train( activationFunctions(1,:), activationFunctions(2,:), allWeights, inputs, expected_outputs, eta );
    
    for i = 1:length(inputs(:,1))
        varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
        varaux{length(neurons_per_layer)-1};
    end
    
    error = test(activationFunctions(1,:), allWeights, inputs, expected_outputs);
    
    if error < min_error
        min_error = error;
    end
    
    errors = [errors error];
    
    debug = debug+1;
    
end

fprintf('\n \n for eta %f  and epochs %d  error: %f\n \n', eta, debug, error);
%for i = 1:length(inputs(:,1))
%    varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
%    fprintf('Expected Output: %d Calculated Output: %f  error: %f\n', expected_outputs(i), varaux{length(neurons_per_layer)-1}(:,2), error);
    
%end
err = error;
end
