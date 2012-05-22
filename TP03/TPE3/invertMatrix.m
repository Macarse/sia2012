function [ vector_output ] = invertMatrix( vector )
%INVERMATRIX Summary of this function goes here
%   Detailed explanation goes here
    
    vector_output = zeros(1,length(vector));
    
    for i = 1:length(vector_output)
        vector_output(i) = vector(i)*-1;
    end


end

