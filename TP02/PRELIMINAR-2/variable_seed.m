function [  ] = variable_seed(  )
%This function provides a variable seed 
%  

rand('state',sum(100 *clock));

end

