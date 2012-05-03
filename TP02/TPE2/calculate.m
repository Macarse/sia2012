function [ output ] = calculate( activationFunction, weights, inputs )
%CALCULATE This function calculates the output from a vector of weights and
%a function, given the input
% ARGS:
%   weights is a vector of 1xN
%   inputs is a vector of 1xN
    output = weights*inputs';
    output = activationFunction(output);

end

