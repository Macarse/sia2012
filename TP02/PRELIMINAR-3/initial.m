%%%%% PARAMETERS DEFINED %%%%%

constant_seed();

N = 3;

% Neuronas en las capas ocultas:
%   Paridad: [N 1]
%   Simetria: [N 1]
%   Xor: [N+1 1]

neurons_per_layer = [N 1];

eta = 0.05;

epsilon  = 0.01;

g = @no_lineal_tanh;

g_deriv = @no_lineal_deriv_tanh;

lineal_function = @lineal;

lineal_function_deriv = @lineal_deriv;

M = 5000;

func = @evaluation_function;

func_deriv = @evaluation_function_deriv;

%%%%% PROBLEM SOLVER %%%%%

prevError = 0;

error = 1;

neurons_per_layer = [N neurons_per_layer];

numberOfLayers = length(neurons_per_layer(1,:))-1;

allWeights = generateWeights(neurons_per_layer);  

% Cell de NxM donde N = #neuronas en capa i y M = #neuronas+1 (por el bias) en la capa i-1
lastWeights = allWeights

% [inputs, expected_outputs] = generateParityIndexes(N);
%[inputs, expected_outputs] = generateXorIndexes(N);
[inputs, expected_outputs] = generateSymmetricIndexes(N);

% ------------------------------------------------------------------------
%Funcion de activación para cada capa.
activationFunctions = cell(2, numberOfLayers);

activationFunctions(1,numberOfLayers) = {lineal_function};
activationFunctions(2,numberOfLayers) = {lineal_function_deriv};

for i = 1:numberOfLayers-1
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
    % if mod(debug,10) == 0
    %     plot(inputs(:,2),evaluation_function(inputs(:,2)),inputs(:,2),evaluateOutput(activationFunctions(1,:), allWeights, inputs(:,2)))
    %     drawnow
    % end
    
    fprintf('Epoca: %d\t Error:%g \tError minimo: %g\n',debug, error, min_error);
end

hold on;
epocas = [0:1:debug];
plot(epocas, errors, 'r');
xlabel('Epocas');
ylabel('Error cuadratico medio');

%indexes = randperm(2^N);
for i = 1:length(inputs(:,1))
    varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
    fprintf('Expected Output: %d Calculated Output: %f \n', expected_outputs(i), varaux{length(neurons_per_layer)-1}(:,2));
    
end



