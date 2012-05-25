
directory_name = 'images/';
output_directory_name = 'newOutput/';
fileNamesForTesting = {'circleDer.png', 'circleIzq.png'};

files = dir(directory_name);
fileIndex = find(~[files.isdir]);

vectors = [];
        
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

            fileNames = {fileNames{:},fileName};
            continue;
        end
    end 
end
weights = generateWeights(vectors);
