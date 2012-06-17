%% plotter: function description
function [] = plotter(namefile)

values = load(namefile);

generations = values(:,1);
best = values(:,2);
worst = values(:,3);
means = values(:,4);
sd = values(:,5);

p = plot(generations, best, 'r', generations, means, 'b', generations, sd, 'g');
ylabel('Fitness');
xlabel('Generaciones');
leg = legend('Mejor', 'Medio', 'Desvio estandar');
set(leg, 'Location', 'NorthWest');

end