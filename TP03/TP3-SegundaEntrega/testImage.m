function [ ] = testImage(weights, imageToTest)
directory_name = 'images/';
new_filename = strcat(directory_name, imageToTest);
vector = loadImage(new_filename);
output = getAsyncOutput(weights, vector);
output = vec2mat(output, 64, 64);

imshow(output);
