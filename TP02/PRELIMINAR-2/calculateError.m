function [ error ] = calculateError( g, w, epoc, expected_output)
%TEST this function tests that the perceptron has learnt

    calculated_output = zeros(length(expected_output),1);

    sum = 0;
    for i=1:length(epoc)
        calculated_output(i) = calculate(g, w, epoc(i,:));
        aux = calculated_output(i) - expected_output(i);
        aux = aux^2;
        sum = sum+aux;
        
    end
    
    %calculated_output-expected_output
    
    sum = 0.5*sum;
    
    error = sum;
    %error = (calculated_output, expected_output);

end
