package g4.parseLine;

import gps.SearchStrategy;

import org.kohsuke.args4j.Option;

public class CommandLineParser {

	@Option(name="-s", aliases={"--strategy"}, usage="Select the Strategy to solve [BFS | DFS | IterativeDepth ]")
	private SearchStrategy strategies;
	

	@Option(name="-l", aliases={"--level"}, usage="Select the game you want to play[ 1 | 2 | 3 | 4 ]")
	private int level;
	
	private boolean hasToDraw = false;
	
	public boolean help = false;
	
	public SearchStrategy getStrategy() {
		return strategies;
	}

	
	public int getLevel(){
		return level;
	}
	
	public boolean hasToDraw(){
		return hasToDraw;
	}
	
	@Option(name="--help", usage="Print the usage of each parameters")
	public void showHelp(boolean flag){
		help = true;
	}
}
