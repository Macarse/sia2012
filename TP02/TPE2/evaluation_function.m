function [ y ] = evaluation_function( x )
%EVALUATIONFUNCTION Takes x and returns that value evaluated in the
%function provided in this file

    %x = x*15;
    y = sin(x)+6*(cos(x).*cos(x));
    %y = sin(x + 2*x.^2 + 3*x.^3);
    %y = (sin(x)).^5 .* x;
    
end

