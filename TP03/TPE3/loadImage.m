function [ vectorImage ] = loadImage( image )
%LOADIMAGE This function load the image and vectorize it.

    I = imread(image);
    I = I(:,:,1);
    I = im2double(I);
    I = (I*2)-1;
    n = length(I);
    vectorImage = reshape(I', 1, n^2);
end

