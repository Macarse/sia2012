%%%%% PARAMETERS DEFINED %%%%%

N = 2;

% 2 por la cantidad de entradas.
% 6 por la longitud del intervalo.
% 12 por cantidad de picos por longitud del intervalo.

constant_seed();

neurons_per_layer = [10 10 1];

eta = 0.4;

epsilon  = 0.01;

g = @no_lineal_exp;

g_deriv = @no_lineal_deriv_exp;

lineal_function = @no_lineal_exp;

lineal_function_deriv = @no_lineal_deriv_exp;

M = 351;

etaDecrement = 0.01;

etaIncrement = 0.1;

k = 5;

etaAdapIsEnabled = 0;

momentumIsEnabled = 0;

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

[inputs, expected_outputs, inputs_test, expected_outputs_test] = generateInputFromFile('samples3.txt', .40, 0);

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

    % if mod(debug,5) == 0
    %     figure(1);
    %     outputs_test = [];
    %     hold off;
    %     for i = 1:length(inputs_test(:,1))
    %         varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs_test(i,:));
    %         outputs_test = [outputs_test varaux{length(neurons_per_layer)-1}(2)];
    %     end
    %     plot(expected_outputs_test, outputs_test, 'b*');

    %     hold on;
    %     outputs_training = [];
    %     for i = 1:length(inputs(:,1))
    %         varaux = calculateOutput(activationFunctions(1,:), allWeights, inputs(i,:));
    %         outputs_training = [outputs_training varaux{length(neurons_per_layer)-1}(2)];
    %     end
    %     % plot(expected_outputs, outputs_training, 'r*');
    %     axis([0 1 0 1]);

    %     xlabel('Salida esperada');
    %     ylabel('Salida real');
    %     hleg1 = legend('Patrones de testeo','Patrones de entrenamiento');
    %     set(hleg1,'Location','NorthEast');

    %     figure(2);
    %     plot(errors_test_graph, 'b');
    %     hold on;
    %     plot(errors_graph, 'r');
    %     xlabel('Epocas');
    %     ylabel('Error');
    %     hleg1 = legend('Error de testeo','Error de entrenamiento');
    %     set(hleg1,'Location','NorthEast');
    %     drawnow;
    % end

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



