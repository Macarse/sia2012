function [ matrix, expected_output ] = generateParityIndexes( N )
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
  parity = 0;
  for i = 1:N+1
      if (matrix(j,i) == 1)
        parity = parity + 1;
      end
  end
  
  if ( parity ~= 0 && mod(parity,2) == 0)
    expected_output(j,1) = 1;
  end
end

end