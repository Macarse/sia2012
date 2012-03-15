package g4.parseLine;

import gps.SearchStrategy;

import org.kohsuke.args4j.Option;

public class CommandLineParser {

	@Option(name="-s", aliases={"--strategy"}, usage="Select the Strategy to solve [BFS | DFS | AStar | IterativeDepth | Greedy]")
	private SearchStrategy strategies;
	
//	@Option(name="-h", aliases={"--heuristic"}, usage="Select the heuristics [EmptySpaces | EmptySpaces_for_turns | Grades_Sum | Amount_of_Walkable_Cells | Unreachable_space | Cell_Grade_Evaluation | Costh | Cols_Filled | Rows_Filled | Starting_Point]")
//	private List<String> heuristics;

	@Option(name="-l", aliases={"--level"}, usage="Select the game you want to play[ 1 | 2 | 3 | 4 | 5 | -1]")
	private int level;
	
	private boolean hasToDraw = false;
	
	public boolean help = false;
	
	public SearchStrategy getStrategy() {
		return strategies;
	}

//	public List<GPSHeuristic> getHeuristics() {
//		List<GPSHeuristic> heuristics = Lists.newArrayList();
//		if(this.heuristics != null) {
//			for (String gpsHeuristic : this.heuristics) {
//				WPSHeuristic h = WPSHeuristic.fromString(gpsHeuristic);
//				if (h != null) heuristics.add(HeurisitcFactory.getHeuristic(h));
//			}
//		}
//		return heuristics;
//	}
//
//	public WPSLevel getLevel() {
//		return WPSLevel.fromInteger(level);
//	}
	
//	@Option(name="-d", aliases={"--drawing"}, usage="Choose if you want to draw the board")
//	public void setDrawing(boolean flag){
//		hasToDraw = flag;
//	}
	
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
