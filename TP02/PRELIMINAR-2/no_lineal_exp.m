function [ y ] = no_lineal_exp( x )
%NO_LINEAL_DERIV 

    beta = 1;

    y = (1+exp(-2*beta*x))^(-1);

end

