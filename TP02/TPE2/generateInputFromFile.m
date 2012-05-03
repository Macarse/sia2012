function [ inputs_train, expected_outputs_train, inputs_test, expected_outputs_test ] = generateInputFromFile(fileName, percentForTraining, convertPoint)

% GENERATEINPUT given a step, generates the values of the given function
% (func) from the initial x value, to the end x value
% The output is a matrix with all the sequences and the expected output
    
    % Load File.
    values = load(fileName);

    % Amount of elements for training and testing.
    qtyTraining = int16(length(values) * percentForTraining);
    qtyTest = length(values) - qtyTraining;

    inputs_train = zeros(qtyTraining,1);
    inputs_test = zeros(qtyTest, 1);

    expected_outputs_train = zeros(qtyTraining,1);
    expected_outputs_test = zeros(qtyTest,1);

    totalIndexes = [1:1:length(values)];
    indexesPermutted = randperm(length(totalIndexes));

    % Get indexes for Training Group
    indexesForTraining = indexesPermutted(1, 1:qtyTraining);
    % Get indexes for Test Group.
    firstIndexForTesting = qtyTraining+1:length(values);
    indexesForTesting = indexesPermutted(1, firstIndexForTesting);
    
    inputs_train(:,1) = -1;     % Add bias
    inputs_train(:,2) = values(indexesForTraining, 1);  % Get first column of points for Training
    inputs_train(:,3) = values(indexesForTraining, 2);  % Get second column of points for Training
    
    if convertPoint == 1
        % Convert each point to [-1,1]
        maxs = ceil(max(abs(inputs_train)));
        inputs_train(:,2) = inputs_train(:,2)./ maxs(2);
        inputs_train(:,3) = inputs_train(:,3)./ maxs(3);
    end

    % Remove every input from training that it is < 0.01
    % Get expected output for training
    expected_outputs_train(:,1) = values(indexesForTraining, 3);
    q = find(expected_outputs_train > 0.01);
    expected_outputs_train = expected_outputs_train(q);
    inputs_train = inputs_train(q,:);

    inputs_test(:,1) = -1;     % Add bias - I dont know if it is neccessary.
    inputs_test(:,2) = values(indexesForTesting, 1);  % Get first column of points for Testing group
    inputs_test(:,3) = values(indexesForTesting, 2);  % Get second column of points for Testing group
    
    if convertPoint == 1
        % Convert each point to [-1,1]
        maxs = ceil(max(abs(inputs_test)));
        inputs_test(:,2) = inputs_test(:,2)./ maxs(2);
        inputs_test(:,3) = inputs_test(:,3)./ maxs(3);
    end

    expected_outputs_test(:,1) = values(indexesForTesting, 3);    % Get expected output for testing group

    
end