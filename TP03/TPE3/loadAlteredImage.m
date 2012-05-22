function [ vectorImage ] = loadAlteredImage( image, start_x, start_y, size_x, size_y, percent )
%LOADALTEREDIMAGE Summary of this function goes here
%   Detailed explanation goes here

    I = imread(image);
    I = I(:,:,1);
    I = im2double(I);
    I = (I*2)-1;
    n = length(I);
    alter_rand = rand(size_x, size_y);
    alter = matrixGreatherThan(alter_rand, percent);
    alter = alter*-2+1;
    I(start_x:start_x+size_x-1, start_y:start_y+size_y-1) = I(start_x:start_x+size_x-1, start_y:start_y+size_y-1).*alter;
    vectorImage = reshape(I', 1, n^2);
end

