function [  ] = constant_seed( )
%This function provides a constant seed in order to be able to compare
%different activation functions
%  

rand('state', 9973);

end

