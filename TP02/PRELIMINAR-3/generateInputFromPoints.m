function [ inputs, expected_outputs ] = generateInputFromPoints(  step, initial_value, end_value, func, func_deriv )
%GENERATEINPUT given a step, generates the values of the given function (func) from the
%initial x value, to the end x value
% The output is a matrix with all the sequences and the expected output

    delta_deriv = 0.5;

    x = generatePoints( initial_value, end_value, func_deriv, step, delta_deriv );
    
    %x = x/15;
    
    inputs = zeros(length(x),1);
    
    expected_outputs = zeros(length(x),1);
    
    fprintf('La cantidad de puntos es %d\n',length(x));

    for i = 1:length(x)
        inputs(i,1) = -1;
        
        inputs(i,2) = x(i);
        
        expected_outputs(i,1) = func(x(i));
    end

    
    plot(x,expected_outputs(:,1),'+')
end

