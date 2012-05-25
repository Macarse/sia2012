function [] = loadAllImages()
%LOADALLIMAGES 

directory_name = 'images/';
files = dir(directory_name);

fileIndex = find(~[files.isdir]);

for i = 1:length(fileIndex)
	fileName = files(fileIndex(i)).name;
	if fileName(1) ~= '.'
	    fileName = strcat('images/',fileName);
	    loadImage(fileName)
	end
end

end

