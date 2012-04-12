function [ input, result, weights ] = initial(N, eta, epsilon, createInput, g, g_deriv)
%   w is a vector of Nx1
%   input(i) is a vector of 1xN

w =  (rand(N+1,1)-0.5)/1;   
[input, expected_output] = createInput(N);
error = 1;
epochs = 1;

while (error > epsilon)
    
    indexes = randperm(2^N);

    for i = 1:length(indexes)
        w = learn(g, g_deriv, w, input(indexes(i),:), expected_output(indexes(i)), eta);

    end

    error = calculateError(g, w, input, expected_output)
    epochs = epochs + 1;
    
    
end

weights = w;

indexes = randperm(2^N);
result = zeros(length(indexes), 1);
for i = 1:length(indexes)
    result(i) = calculate(g, w, input(i,:));
end



