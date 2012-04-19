function [ error ] = test( activationFunctions, allWeights, inputs, expected_output )
%TEST function that test a perceptron and returns the error

    calculated_output = zeros(size(expected_output));

    
    
    for i=1:length(inputs(:,1))
        one_calculated_output = calculateOutput(activationFunctions, allWeights, inputs(i,:));
        auxVector = one_calculated_output{length(allWeights)};
        auxVector = auxVector(2:end);
        calculated_output(i) = auxVector;
    end
    
    %calculated_output
    %expected_output
    error_matrix = (calculated_output - expected_output).^2;
    
    error = sum(error_matrix);
     
    error = 0.5*error;


end

