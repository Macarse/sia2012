function [ y ] = no_lineal_exp(xx)
%NO_LINEAL_DERIV 

    beta = 2;
    y = (1+exp(-2 * beta * xx))^(-1);

end

