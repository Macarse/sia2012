function [ outputs ] = calculateOutput( activationFunctions, allWeights, inputs )
%CALCULATEOUTPUT This function calculates the output of an entire
%perceptron
% ARGS:
%   -activationsFunctions: Column Vector of activationFunctions for each
%       layer
%   -allWeigths: Cell of matrixes. [vector of matrixes]
%   -inputs: 1 pattern
% RET: 
%   A cell of vectors representing the output of each level (Asc Order)



    outputs = cell(length(allWeights),1);

    
    for i = 1:length(allWeights)
       inputs = calculateLayer(activationFunctions{i}, allWeights{i}, inputs); 
       outputs{i} = inputs;
    end
    
end

