function [ weights ] = generateWeights( patterns )
%Generate the weights matrix for a Hopfield net
%   patterns: a matrix where each row is an individual pattern
    n = length(patterns(1, :));
    weights = patterns'*patterns;
    for i=1:n
        weights(i, i)=0;
    end
    weights = weights()/n;
end

