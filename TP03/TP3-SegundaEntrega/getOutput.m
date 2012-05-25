function [ status ] = getOutput( weights, pattern )
%GETOUTPUT Summary of this function goes here
%   pattern: 1 * n
%   weights: n * n
    newStatus = pattern;
    oldStatus = zeros(size(pattern));
    while (oldStatus ~= newStatus)
        olderStatus = oldStatus;
        oldStatus = newStatus;
        signs = sign((weights*oldStatus')');
        for i=1:length(pattern(1,:))
           if (signs(i)~=0)
               newStatus(i) = signs(i);
           end
        end
        if olderStatus == newStatus
            fprintf('Entre en un ciclo');
            break;
        end
    end
    status = newStatus;
end

