function [ inputs, expected_outputs ] = generateInput( step, initial_value, end_value, func )
%GENERATEINPUT given a step, generates the values of the given function (func) from the
%initial x value, to the end x value
% The output is a matrix with all the sequences and the expected output

    
    inputs = zeros((initial_value-end_value)/step,1);

    expected_outputs = zeros((initial_value-end_value)/step,1);
    
    i = 0;
    
    for x = initial_value:step:end_value
        i = i+1;
        inputs(i,1) = -1;
        
        inputs(i,2) = x;
        
        expected_outputs(i,1) = func(inputs(i,2));
    end

end

