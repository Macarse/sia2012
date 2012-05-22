function [ vector_output ] = crazyMatrix( vector )
%CRAZYMATRIX Summary of this function goes here
%   Detailed explanation goes here

    randoms = randperm(length(vector));
    
    vector_output = zeros(1,length(vector));
    
    for i = 1:length(randoms)
        vector_output(i) = vector(randoms(i));
    end


end

