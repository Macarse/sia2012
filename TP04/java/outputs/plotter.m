%% plotter: function description
function [] = plotter(namefile)

values = load(namefile);

generations = values(:,1);
best = values(:,2);
worst = values(:,3);
means = values(:,4);

p = plot(generations, best, 'r', generations, worst, 'b', generations, means, 'g');
ylabel('Fitness');
xlabel('Generaciones');
leg = legend('Best', 'Worst', 'Median');
set(leg, 'Location', 'NorthWest');

end