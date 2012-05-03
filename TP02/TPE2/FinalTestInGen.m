function [ inputs ] = FinalTestInGen( step )
%UNTITLED Summary of this function goes here
%   Detailed explanation goes here

start = -3.5;
out = [];
while start < 3.5
    start2 = -3.5;
    while start2 < 3.5
        out = [out; -1, start , start2]
        start2 = start2 + step;
    end
    start = start + step;
end
inputs = out;

end

