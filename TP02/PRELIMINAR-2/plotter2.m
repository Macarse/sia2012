function [ input, result, weights, errorRta] = plotter2(N, epsilon, createInput, eta, seed)
%   w is a vector of Nx1
%   input(i) is a vector of 1xN
%   seed: function that determinates the seed been used in the hole run.
%   This is in order to be able to use many times the same seed and compare
%   algorithms better.

seed();
MAX_EPOCS = 15000;
w_back =  (rand(N+1,1)-0.5)/1;   
[input, expected_output] = createInput(N);

nLines = 4;
legend_str = cell(nLines,1);
index = 1;

clf;
linestyles = hsv(5);
functions = {@step, @step_deriv; @lineal, @lineal_deriv; @no_lineal_exp, @no_lineal_deriv_exp; @no_lineal_tanh, @no_lineal_deriv_tanh};

hold all;
for j = 1 : 1 : 4
    w = w_back;
    
    error = 1;
    error_var = 1;
    epochs = 1;
    
    epochsData = [];
    errorData = [];

    while (error > epsilon && ~( error_var <  0.0000001 && -0.09 < error - epsilon > 0.1))

        indexes = randperm(2^N);

        for i = 1:length(indexes)
            w = learn(functions{j, 1}, functions{j, 2}, w, input(indexes(i),:), expected_output(indexes(i)), eta);

        end
        old_error = error;
        error = calculateError(functions{j, 1}, w, input, expected_output);
        epochs = epochs + 1;
        
        epochsData = [epochsData; epochs];
        errorData = [errorData; error];
        if epochs > 300 
            error_var = (mean(errorData(epochs - 200:epochs-1,1)) - error )^ 2;
        end
        %         asd = sum(errorData(max(0,epocs - 100):1: ,1));
       errorRta = error;
     
    end

    plot(epochsData, errorData, '-', 'Color', linestyles(index, :));
    hold on;
    
    legend_str{index } =strcat('eta = ', num2str(eta));

    index = index + 1;
end


weights = w;

indexes = randperm(2^N);
result = zeros(length(indexes), 1);

end



