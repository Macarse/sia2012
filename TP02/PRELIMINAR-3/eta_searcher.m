function [] = eta_searcher()

fprintf('\n \n \n----------------- TANH   SYM -----------------------');
for eta=0.01:0.01:0.2
	 err = solver(@no_lineal_tanh, @no_lineal_deriv_tanh, 5, @generateSymmetricIndexes,0.01, eta);
%	 if err <= 0.01
%	 	break;
%	 end
end

fprintf('\n \n \n----------------- LINEAL   SYM -----------------------');
for eta=0.01:0.01:0.2
	 err = solver(@lineal, @lineal_deriv, 5, @generateSymmetricIndexes,0.01, eta);
%	 	 if err <= 0.01
%	 	break;
%	 end
end

fprintf('\n \n \n----------------- STEP   SYM -----------------------');
for eta=0.01:0.01:0.2
	err = solver(@step, @step_deriv, 5, @generateSymmetricIndexes_stepWrap,0.01, eta);
%	 	 if err <= 0.01
%	 	break;
%	 end
end

fprintf('\n \n \n----------------- TANH   PAR -----------------------');
for eta=0.01:0.01:0.2
	 err = solver(@no_lineal_tanh, @no_lineal_deriv_tanh, 5, @generateParityIndexes,0.01, eta);
%	 if err <= 0.01
%	 	break;
%	 end
end
fprintf('\n \n \n----------------- LINEAL   PAR -----------------------');
for eta=0.01:0.01:0.2
	 err = solver(@lineal, @lineal_deriv, 5, @generateParityIndexes,0.01, eta);
%	 	 if err <= 0.01
%	 	break;
end


fprintf('\n \n \n----------------- STEP   PAR -----------------------');
for eta=0.01:0.01:0.2
	err = solver(@step, @step_deriv, 5, @generateParityIndexes_stepWrap,0.01, eta);
%	 	 if err <= 0.01
%	 	break;
%	 end
end
end