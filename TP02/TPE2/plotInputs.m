
constant_seed();

[inputs, expected_outputs, inputs_test, expected_outputs_test] = generateInputFromFile('samples3.txt', .80, 0);

x = inputs(:,2);
y = inputs(:,3);
plot3(x,y, expected_outputs, 'b*');
hold on;
xx = inputs_test(:,2);
yy = inputs_test(:,3);
plot3(xx,yy, expected_outputs_test, 'r*');
hleg1 = legend('Patrones de entrenamiento', 'Patrones de testeo');
set(hleg1,'Location','NorthEast');

