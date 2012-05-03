function [ output ] = generatePoints( lower_bound, upper_bound, curve_deriv, step, delta_deriv )
%GENERATEPOINTS Summary of this function goes here
%   Detailed explanation goes here
    i = 1;
    init_step = step;
    step = step/5;
    x = lower_bound;
    old_deriv = curve_deriv(x);
    x = x + step;
    %output = zeros(1, (upper_bound-lower_bound)/(step*2));
    while(x < upper_bound)
        output(i) = x;
        new_deriv = curve_deriv(x);
        if (abs(new_deriv-old_deriv)>delta_deriv && step >= init_step/5)
        %if (abs(new_deriv)>delta_deriv && step >= init_step/10)
            step = step / 1.05;
        else
            if (step <= init_step*5)
                step = step * 1.1;
            end
        end
        output(i) = x;
        i = i+1;
        x = x + step;
        old_deriv = new_deriv;
        new_deriv = curve_deriv(x);
        fprintf('%f\n',x);
    end

end

