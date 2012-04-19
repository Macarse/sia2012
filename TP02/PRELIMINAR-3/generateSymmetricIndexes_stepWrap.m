function [ matrix, expected_output ] = generateSymmetricIndexes_stepWrap( N )
[ matrix, expected_output ] = generateSymmetricIndexes( N );
aux = matrix(:,1);
matrix = matrix(:,2:end)*2;
matrix = matrix -1;
matrix = [aux , matrix]; 
expected_output = expected_output *2 -1;
matrix;
end
