function [ outputs ] = calculateLayer( activationFunction, weights, inputs )
%CALCULATELAYER This function calculates the output of an entire layer of
%neurons



    outputs = zeros(1,length(weights(:,1)));
    
    for i = 1:length(weights(:,1))     
       outputs(1,i) = calculate(activationFunction, weights(i,:), inputs);
    end
    outputs = [-1 outputs]; 
    
    

end

