function [ y ] = evaluation_function_deriv( x )
%EVALUATION_FUNCTION_DERIV
   
    %x = x*15;
    y = cos(x).*(1-12*sin(x));
    %y = cos(x + 2*x.^2 + 3*x.^3) .* (1+4*x+9*x.^2);
    %y = (sin(x))^4 .* (sin(x) + 5.*x.*cos(x));

end

