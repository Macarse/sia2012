package edificios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exceptions.CorruptFileException;


public class BuildingParser {
	
	public static Board parse(String fileName) throws FileNotFoundException, CorruptFileException, IOException{
		File file = new File(fileName);
		BufferedReader  in = new BufferedReader(new FileReader(file));
		Board ret = null;
		try{
			int dimension = Integer.valueOf(in.readLine().trim());	
			ret = new Board(dimension);
			int i,j;
			int[][] restrs = new int[4][dimension];
			for (i = 0; i < 4 ;i++) {
				String line = in.readLine().trim();
				if (line == null) {
					throw new CorruptFileException("Number of rows is invalid.");
				}
				String[] num = line.split(",");
				if (num.length != dimension)
					throw new CorruptFileException("Row numbers does not match declared dimension.");
				for ( j = 0 ; j < dimension; j++) {
					restrs[i][j] = Integer.valueOf(num[j]);
				}
			}
			Settings.restrictions = restrs;
		} catch(NumberFormatException e) {
			throw new CorruptFileException("File contains invalid characters. See README for format details.");
		}
		return ret;
	}
}

