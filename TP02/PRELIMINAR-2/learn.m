function [ w_out ] = learn( g, g_deriv, w, input, expected_output, eta )
%LEARN given initial weights, changes the weights training the perceptron
   
    calculated_output = calculate(g, w, input);

    g_prima_evaluated = calculate(g_deriv, w, input);
    
    delta_w = (expected_output - calculated_output)*g_prima_evaluated;
    
    Delta_w = eta * delta_w * input;
    
    w_out = w + Delta_w';

end

