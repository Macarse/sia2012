directory_name = 'images/';

files = dir(directory_name);
fileIndex = find(~[files.isdir]);

vectors = [];
altered_vectors = [];

fileNames = {};
indexes = [];

for i = 1:length(fileIndex)

    fileName = files(fileIndex(i)).name;
    new_filename = strcat(directory_name,fileName);
    if ( length(new_filename) < 3 )
        continue;
    end

    vector = loadImage(new_filename);
    vectors = [vectors; vector];
    fileNames = {fileNames{:},fileName};
end

maxFound = -1;
maxResult = [];
for i = 1:2

	ix = randperm(length(vectors(:,1)));
	randVectors = vectors(ix, :);
	patternsCount = 1;
	weights = generateWeights(randVectors(1,:));
	failed = false;

	for j = 2:length(randVectors(:,1))
		ct = crossTalk(weights, randVectors(j,:));
		if ( ct < 1 )
			patternsCount = patternsCount + 1;
			weights = generateWeights(randVectors(1:j,:));
		else
			failed = true;
			if (patternsCount > maxFound)
				maxFound = patternsCount
				maxResult = ix;
			end

			break
		end

	end
	
	if ( failed  == false )
		a = 'NO FALLO'
		break
	end

end


