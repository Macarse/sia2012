directory_name = 'images/';
output_directory_name = 'output/';
altered_directory = 'altered/';
output_altered_directory = 'outputAltered/';
noisy_images = 'noisyImages/';
%fileNamesForTesting = { 'line1.png', 'line2.png', 'line3.png', 'line4.png', 'crouched.png'};
% fileNamesForTesting = { 'a.png',  'circle1.png', 'line1.png', 'line2.png'};
% fileNamesForTesting = { 'a.png',  'circle1.png', 'line1.png', 'line2.png'};
fileNamesForTesting = { 'mac.png',  'circle1.png', 'line1.png', 'line3.png'};
% fileNamesForTesting = {'line1.png', 'line2.png', 'line3.png', 'line4.png', 'crouched.png', 'f.png'};


fileNamesForOutput = {
    'noisyImages/altered_01-f.png',
    'noisyImages/altered_02-f.png',
    'noisyImages/altered_03-f.png',
    'noisyImages/altered_04-f.png',
    'noisyImages/altered_05-f.png',
    'noisyImages/altered_06-f.png',
    'noisyImages/altered_07-f.png',
    'noisyImages/altered_08-f.png',
    'noisyImages/altered_09-f.png'
    };

files = dir(directory_name);

fileIndex = find(~[files.isdir]);

noisyFiles = dir(noisy_images);

noisyIndex = find(~[noisyFiles.isdir]);

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

            % Alteracion de la imagen en un 50% de sus puntos
            % altered_vector = loadAlteredImage(new_filename, 1, 1, 64, 64, 0.4);
            % altered_vectors = [altered_vectors; altered_vector];
            % saveImage(altered_vector, strcat(altered_directory, 'altered_', num2str(0.4), '-' ,fileName));

            fileNames = {fileNames{:},fileName};
            continue;
        end
    end 
end
weights = generateWeights(vectors);
%%Verify if the patterns have been learned
%%
%%

for i = 1:length(fileNamesForTesting)
    new_filename = strcat(directory_name,fileNamesForTesting{i});
    vector = loadImage(new_filename);
    output = getAsyncOutput(weights, vector);
    saveImage(output, strcat(output_directory_name, 'output_', fileNamesForTesting{i}));
end

%
%   use the altered patterns to see if the errors are fixed
%

%--------------------------------------------------------------------------------------------------
% COMENTADO
for i = 1:length(noisyIndex)
    fileName = noisyFiles(noisyIndex(i)).name;
            if(  fileName(1) ~= '.')

            new_filename = strcat(noisy_images,fileName);
            vector = loadImage(new_filename);
            output = getAsyncOutput(weights, vector);
            saveImage(output, strcat(output_directory_name, 'output_noisyImages/', noisyFiles(noisyIndex(i)).name));
        
    end
end


% for i = 1:length(fileIndex)
%     fileName = files(fileIndex(i)).name;
%     
%     for j = 1:length(fileNamesForTesting)
%                 test = fileNamesForTesting{j};
%         if( strcmp(test, fileName) && fileName(1) ~= '.')
%             new_filename = strcat(directory_name,fileName);
%             vector = loadImage(new_filename);
%             output = getOutput(weights, vector);
%             saveImage(output, strcat(output_directory_name, 'output_noisyImages/', fileNamesForTesting{j}));
%         end
%     end
% end

% for i = 1:length(fileNamesForOutput)
%      vector = loadImage(fileNamesForOutput{i});
%      output = getOutput(weights, vector);
%      % Si quiero guardar la salida
%      saveImage(output, strcat(output_directory_name, 'output_', fileNamesForOutput{i}));
%  
%      % Si quiero guardar la salida con alteraciones en la entrada.
%      % saveImage(output, strcat(output_altered_directory, 'altered_output_', fileNames{i}));
%     
% end
%
% Inverted patterns
%

%--------------------------------------------------------------------------------------------------
% COMENTADO
  for i = 1:length(fileIndex)
     fileName = files(fileIndex(i)).name;
    
    for j = 1:length(fileNamesForTesting)
                 test = fileNamesForTesting{j};
         if( strcmp(test, fileName) && fileName(1) ~= '.')
             new_filename = strcat(directory_name,fileName);
             vector = loadImage(new_filename);
             vector = vector * -1;
             output = getAsyncOutput(weights, vector);
             saveImage(output, strcat(output_directory_name, 'output_Inverted_', fileNamesForTesting{j}));
         end
     end
  end

 %
 %  Using images that are not like the ones lerned
 %
%--------------------------------------------------------------------------------------------------
% COMENTADO
 for i = 1:length(fileIndex)
    fileName = files(fileIndex(i)).name;
    inTesting = false;
    for j = 1:length(fileNamesForTesting)
          test = fileNamesForTesting{j};
        if( strcmp(test, fileName) && fileName(1) ~= '.' )
          inTesting = true;
        end
        
    end
    if (~inTesting && fileName(1) ~= '.')
      new_filename = strcat(directory_name,fileName);
            vector = loadImage(new_filename);
            output = getAsyncOutput(weights, vector);
            saveImage(output, strcat(output_directory_name, 'output_Not_Lerned_', fileName));
    end
end