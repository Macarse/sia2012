function [ crosstalk ] = crossTalk( patterns, pattern )
%CROSSTALK 

    crosstalk = (patterns'*patterns*pattern')./length(pattern) - pattern';
end

