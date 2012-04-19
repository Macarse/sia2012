function [ matrix, expected_output ] = generateSymmetricIndexes( N )
%CREATEINPUT given a length N, creates all the possible sequences of bits of
%length N
% The output is a matrix with all the sequences

matrix = zeros(2^N, N+1);
numberToComplete = 0;
expected_output = ones(2^N,1);

for i = 1:N
    for j = 1:2^N
       if(mod(j-1,2^(i-1)) == 0)
           if(numberToComplete == 0)
                numberToComplete = 1;
           else
               numberToComplete = 0;
           end
       end
       matrix(j,i+1) = numberToComplete;
    end
end

for j = 1:2^N
    matrix(j,1) = -1;
end

count = (N/2)+2;
  if ( mod(N,2) == 0)
    count = N/2+1;
  end
  
for j = 1:2^N
  reverseIndex = length(matrix(1,:));
  fprintf('Reverse Index Start: %d\n', reverseIndex);
  
  for i = 2:count
    %fprintf('Matrix(j,i) = %d Matrix(j,reverseIndex) = %d\n', matrix(j,i), matrix(j,reverseIndex));
    if ( matrix(j,i) ~= matrix(j, reverseIndex) )
        expected_output(j) = 0;
        break;
    end
    reverseIndex = reverseIndex - 1;
  end
end

end