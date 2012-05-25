function [ status ] = getAsyncOutput( weights, pattern )
%GETOUTPUT Summary of this function goes here
%   pattern: 1 * n
%   weights: n * n
    newStatus = pattern;
    oldStatus = zeros(size(pattern));
    times = 0;
    while (~isequal(oldStatus, newStatus))
        oldStatus = newStatus;
        indexes = randperm(length(pattern(1,:)));
        for i=1:length(newStatus)
            j = indexes(i);
            
            newStatus(j) = sign(sum(weights(j,:) * newStatus')); 
        
        end
        times = times+1;
      % imshow(vec2mat(newStatus, 64, 64));
   
    end
    status = newStatus;
end

