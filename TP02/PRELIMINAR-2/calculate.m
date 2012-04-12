function [ output ] = calculate( g, w, input )
%CALCULATE This function calculates the output from a vector of weights and
%a function, given the input
% ARGS:
%   w is a vector of Nx1
%   input is a vector of 1xN

    output = input*w;
    output = g(output);

end

