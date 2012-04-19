function [ y ] = evaluateOutput(activationFunctions, allWeights, x )
%EVALUATEOUTPUT 

    y = zeros(length(x),1);
    
    inputs = zeros(length(x),2);
    
    
    for i = 1:length(x)
        inputs(i,1) = -1;
        inputs(i,2) = x(i);
        varAux = calculateOutput(activationFunctions, allWeights, inputs(i,:));
        y(i) = varAux{length(allWeights)}(1,end);

    end
end

