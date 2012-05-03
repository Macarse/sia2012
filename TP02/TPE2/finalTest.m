function [ out] = finalTest( in )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here

%neurons_per_layer = [2 neurons_per_layer];

%numberOfLayers = length(neurons_per_layer(1,:))-1;

%activationFunctions = cell(2, numberOfLayers);


%for i = 1:numberOfLayers
%   activationFunctions(1,i) = {@no_lineal_exp};
%   activationFunctions(2,i) = {@no_lineal_deriv_exp};
%end

 %       outputs_training = [];

% for i = 1:length(inputs(:,1))
 %           varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
  %          outputs_training = [outputs_training varaux{length(neurons_per_layer)-1}(2)];
            %            outputs_training = [outputs_training varaux{length(neurons_per_layer)-1}(2)];
% end
 %       outputs = outputs_training;







%%%%% PARAMETERS DEFINED %%%%%

N = 2;

% 2 por la cantidad de entradas.
% 6 por la longitud del intervalo.
% 12 por cantidad de picos por longitud del intervalo.

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

allWeights = generateWeights(neurons_per_layer);  

lastWeights = allWeights;

[inputs, expected_outputs, inputs_test, expected_outputs_test] = generateInputFromFile('samples3.txt', .80, 0);

activationFunctions = cell(2, numberOfLayers);

activationFunctions(1,numberOfLayers) = {lineal_function};
activationFunctions(2,numberOfLayers) = {lineal_function_deriv};

for i = 1:numberOfLayers-1
   activationFunctions(1,i) = {g};
   activationFunctions(2,i) = {g_deriv};
end


debug = 0;

errors = [];
errors_test = [];

errors_graph = [];
errors_test_graph = [];

min_error = 50000;

clf;
while (error > epsilon && debug < M) 
    
    allWeights = train( activationFunctions(1,:), activationFunctions(2,:), allWeights, inputs, expected_outputs, eta, momentumIsEnabled, alpha );
    
    for i = 1:length(inputs(:,1))
        varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
        varaux{length(neurons_per_layer)-1};
    end
    
    error = test(activationFunctions(1,:), allWeights, inputs, expected_outputs);

    error_test = test(activationFunctions(1,:), allWeights, inputs_test, expected_outputs_test);

    if error < min_error
        min_error = error;
    end

    errors_graph = [errors_graph (error / length(inputs))];
    errors_test_graph = [errors_test_graph (error_test / length(inputs_test))];

    errors = [errors error];
    errors_test = [errors_test error_test];
    
    debug = debug+1;

   % if mod(debug,10) == 0
        % plot(inputs(:,2),evaluation_function(inputs(:,2)),inputs(:,2),evaluateOutput(activationFunctions(1,:), allWeights, inputs(:,2)))
        % drawnow
    %end

    if mod(debug,5) == 0
        figure(1);
        outputs_test = [];
        for i = 1:length(inputs_test(:,1))
            varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs_test(i,:));
            outputs_test = [outputs_test varaux{length(neurons_per_layer)-1}(2)];
        end
        outputs_training = [];
        for i = 1:length(inputs(:,1))
            varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
            outputs_training = [outputs_training varaux{length(neurons_per_layer)-1}(2)];
        end
  
    end

    fprintf('Epoca: %d\t Error:%g \tError minimo: %g\t Error de testeo: %g\n',debug, error, min_error, error_test);
    
    if etaAdapIsEnabled == 1
        if debug ~= 0
            etaBkp = eta;
            [prevError, allWeights, eta, curK] = etaAdaptative(prevError, error, lastWeights, allWeights, etaIncrement, etaDecrement, eta, curK, k);
            if eta > etaBkp
                fprintf('Eta aumento a: %g\n',eta);
            elseif eta < etaBkp
                fprintf('Eta disminuyo a: %g\n',eta);
            end
        end
        lastWeights = allWeights;
    end
    
end


%indexes = randperm(2^N);
for i = 1:length(inputs(:,1))
    varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
    varaux{length(neurons_per_layer)-1};
end


  outputs_test = [];
        for i = 1:length(in(:,1))
            varaux = calculateOutput(activationFunctions(1,:), allWeights, in(i,:));
            outputs_test = [outputs_test varaux{length(neurons_per_layer)-1}(2)];
        end
    out = outputs_test;
plot3(in(:,2), in(:,3), out');
end

