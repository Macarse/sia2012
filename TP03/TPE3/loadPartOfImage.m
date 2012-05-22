function [ vectorImage ] = loadPartOfImage( image, start_x, start_y, size_x, size_y)
%LOADALTEREDIMAGE Summary of this function goes here
%   Detailed explanation goes here

    I = imread(image);
    I = I(:,:,1);
    I = im2double(I);
    I = (I*2)-1;
    n = length(I);
    I(start_x:start_x+size_x-1, start_y:start_y+size_y-1) = ones(size_x,size_y);
    vectorImage = reshape(I', 1, n^2);
end

