function [cuadraticError] = testNeuronWithSample(fileName) 

	load bestArch.mat

 	values = load(fileName);
 	qty = length(values);

 	inputs = zeros(qty,1);
 	expected_output = zeros(qty,1);

 	inputs(:,1) = -1;
 	inputs(:,2) = values(:,1);
 	inputs(:,3) = values(:,2);

 	expected_output(:,1) = values(:,3);

	cuadraticError = test(activationFunctions(1,:), allWeights, inputs, expected_output);
	length(values)
	cuadraticError = cuadraticError / length(values);

end