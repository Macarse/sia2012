package g4.parseLine;

import g4.SearchStrategy;

import org.kohsuke.args4j.Option;

public class CommandLineParser {

	@Option(name="-s", aliases={"--strategy"}, usage="Select the Strategy to solve [BFS | DFS | IterativeDepth | Greedy | Astar]")
	private SearchStrategy strategies;
	

	@Option(name="-l", aliases={"--level"}, usage="Select the game you want to play[ 1 | 2 | 3 | 4 ]")
	private int level;
	
	@Option(name="-h", aliases={"--heuristic"}, usage="Select the heuristic [ BiggerRowsFirst | MorePayers | UpperLevelFirst | HStar ]")
	private String heuristic;
	
	@Option(name="-c", aliases={"--cost"}, usage="Select the const that will be used in each pair removale (default 1)")
	private Float cost;
	
	private boolean hasToDraw = false;
	
	public boolean help = false;
	
	public SearchStrategy getStrategy() {
		return strategies;
	}

	public Float getCost(){
		return cost;
	}
	
	public int getLevel(){
		return level;
	}
	
	public boolean hasToDraw(){
		return hasToDraw;
	}
	
	public String getHeuristic(){
		return heuristic;
	}
	@Option(name="--help", usage="Print the usage of each parameters")
	public void showHelp(boolean flag){
		help = true;
	}
}
