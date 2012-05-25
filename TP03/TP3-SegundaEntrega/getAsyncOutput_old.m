function [ status ] = getAsyncOutput( ws, p )
%GETOUTPUT Summary of this function goes here
%   pattern: 1 * n
%   weights: n * n
    
    % newStatus = pattern;
    % oldStatus = zeros(size(pattern));
    % while (oldStatus ~= newStatus)
    %     olderStatus = oldStatus;
    %     oldStatus = newStatus;
    %     signs = sign((weights*oldStatus')');
    %     indexes = randperm(length(pattern(1,:)));
    %     for i=1:length(pattern(1,:))
    %         j = indexes(i);
    %        newStatus(j) = signs(j) + (signs(j) == 0) *  newStatus(j);
    %     end
    % end
    % status = newStatus;

    prev2 = ones(size(p)) .* -1;
    prev1 = p;
    flag = 0;
    s = p;
    while (~flag)
        for (i = randperm(length(p)))
            s(1, i) = sign(ws(i,:) * s');
        end
        flag = all(all(s == prev1)) || all(all(s == prev2));
        prev2 = prev1;
        prev1 = s;
    end
    status = prev1;
end