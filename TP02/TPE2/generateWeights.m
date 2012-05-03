function [ weights ] = generateWeights( neurons_per_layer )
%GENERATEWEIGHTS Given a vector of neurons_per_layer, its returns a vector
%of matrices with all the weights.

factor = 1;
bias = 0.5;

weights = cell(length(neurons_per_layer(1,:))-1,1);

for i = 2:length(neurons_per_layer(1,:))
   weights(i-1) = {(rand(neurons_per_layer(1,i),neurons_per_layer(1,i-1)+1)-bias)/factor};
end


end

