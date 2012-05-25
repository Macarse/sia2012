function [] = generateNoisyImages( )
directory_name = 'images/';
output_directory_name = 'noisyImages/';

% fileNamesForTesting = { 'a_desplazada.png',  'h.png', 'f.png', 'line2.png'};
fileNamesForTesting = { 'mac.png',  'circle1.png', 'line1.png', 'line3.png'};

files = dir(directory_name);

fileIndex = find(~[files.isdir]);

vectors = [];
altered_vectors = [];

fileNames = {};
indexes = [];

for i = 1:length(fileIndex)
    
    fileName = files(fileIndex(i)).name;
    for j = 1:length(fileNamesForTesting)
        test = fileNamesForTesting{j};
        if( strcmp(test, fileName) && fileName(1) ~= '.')
            new_filename = strcat(directory_name,fileName);
            vector = loadImage(new_filename);
            vectors = [vectors; vector];
            
            for k = 0.1:0.1:.9
                altered_vector = loadAlteredImage(new_filename, 1, 1, 64, 64, k);
                altered_vectors = [altered_vectors; altered_vector];
                saveImage(altered_vector, strcat(output_directory_name, 'altered_', num2str(k*10), '-' ,fileName));
            end
            
            fileNames = {fileNames{:},fileName};
            continue;
        end
    end
end

end