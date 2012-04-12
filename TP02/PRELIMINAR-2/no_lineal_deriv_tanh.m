function [ y ] = no_lineal_deriv_tanh( x )
%NO_LINEAL_DERIV derivation of no lineal function

    y = 1*(1-(no_lineal_tanh(x))^2);

end

