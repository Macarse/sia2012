function [ matrix, expected_output ] = generateXorIndexes( N )
%CREATEINPUT given a length N, creates all the possible sequences of bits of
%length N
% The output is a matrix with all the sequences

matrix = zeros(2^N, N+1);
numberToComplete = 0;
expected_output = zeros(2^N,1);

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

for j = 1:2^N
  count = sum(matrix(j,:))+1;
  if ( count > 0 && count < N )
    expected_output(j,1) = 1;
  end
end

end