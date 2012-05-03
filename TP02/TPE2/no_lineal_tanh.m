function [ y ] = no_lineal_tanh( x )
%NO_LINEAL no lineal function

    beta = 0.5;

    y = tanh(beta*x);
    
end

