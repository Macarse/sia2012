directory_name = 'bad3b/';
files = dir(directory_name);

fileIndex = find(~[files.isdir]);

vectors = [];

fileNames = {};

for j = 1:5
for i = 1:length(fileIndex)

    fileName = files(fileIndex(i)).name;
    if(fileName(1) ~= '.')
        new_filename = strcat(directory_name,fileName);
        vector = loadAlteredImage(new_filename, 1, 1, 64, 64, 0.38+j/25);
        vectors = [vectors; vector];        
        fileNames = {fileNames{:},fileName};
        saveImage(vector, strcat(directory_name, 'altered_', num2str(1-(0.38+j/25)), '-' ,fileNames{i-1}));
    end
end
end

%saveImage(v, 'letter_images/altered-32-32-16-16-60_a.png')
for j = 1:5
for i = 1:3 % cambiar esto cuando corresponda
    %crazyMatrixResult = crazyMatrix(vectors(i,:));
    %output = getOutput(weights, crazyMatrixResult);
    i
    j
    (j-1)*3+i
    output = getOutput(weights, vectors((j-1)*3+i,:));
    strcat(directory_name, 'output_', num2str(1-(0.38+j/25)), '-' ,fileNames{i});
    %saveImage(crazyMatrixResult, strcat(directory_name, 'crazy_', fileNames{i}));
    saveImage(output, strcat(directory_name, 'output_', num2str(1-(0.38+j/25)), '-' ,fileNames{i}));
   
end
end