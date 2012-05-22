function [ Y ] = matrixGreatherThan( X, lower_bound )
%MATRIXGREATHERTHAN Summary of this function goes here
%   Detailed explanation goes here
    Y = arrayfun(@(x) x>lower_bound, X);

end

