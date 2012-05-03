function [ y ] = no_lineal_deriv_exp( x )
%NO_LINEAL_DERIV_EXP 

    beta = 2;

    y = 2*beta*no_lineal_exp(x)*(1-no_lineal_exp(x));

end

