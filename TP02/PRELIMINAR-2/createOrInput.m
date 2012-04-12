function [ matrix, expected_output ] = createOrInput( N )
%CREATEINPUT given a length N, creates all the possible sequences of bits of
%length N
% The output is a matrix with all the sequences

matrix = zeros(2^N, N+1);
numberToComplete = -1;
expected_output = ones(2^N,1);

for i = 1:N
    for j = 1:2^N
       if(mod(j-1,2^(i-1)) == 0)
           numberToComplete = numberToComplete*(-1);
       end
       matrix(j,i+1) = numberToComplete;
    end
end

for j = 1:2^N
    matrix(j,1) = -1;
end

expected_output(2^N) = -1;

end

