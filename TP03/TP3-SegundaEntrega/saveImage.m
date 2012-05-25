function [] = saveImage( imageMatrix, image )
%SAVEIMAGE This function save an image

    mat = vec2mat(imageMatrix, 64, 64);
    imwrite(mat, image, 'PNG');

end

