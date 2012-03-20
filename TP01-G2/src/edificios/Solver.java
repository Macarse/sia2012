package edificios;

import edificios2.BoardIteratorStrategy;
import edificios2.BuildingProblem2;
import edificios2.MRVStrategy;
import edificios2.SequenceStrategy;
import edificios2.SpiralStrategy;
import gps.G4GPSEngine;
import gps.GPSEngine;
import gps.SearchStrategy;
import heuristics.Heuristic;
import heuristics.HighRestrictionDensityHeuristic;
import heuristics.LowRestrictionDensityHeuristic;
import heuristics.NoHeuristic;
import heuristics.SimpleHeuristic;

import java.util.HashMap;
import java.util.Map;

import util.Logger;

public class Solver {
	
	private static final String DEFAULT_BUILDER = "red";
	private static final String DEFAULT_LOG_LEVEL = "med";
	
	private static final int ALGORITHM 		= 0;
	private static final int BOARD 			= 1;
	private static final int BOARD_STRATEGY = 2;
	private static final int HEURISTIC		= 3;
	private static final int LOG_LEVEL 		= 4;
	
	private static final int TOTAL_PARAMS	= 5;
	
	public static void main(String[] args) {
		if (args == null || args.length < TOTAL_PARAMS) {
			printUsage();
			return;
		}
		initLogger(args[LOG_LEVEL].toLowerCase());
		initBoardIteratorStrategy(args[BOARD_STRATEGY].toLowerCase());
		//GPSEngine gps = initGPS(args[ALGORITHM].toLowerCase());
		Board level;
		try {
			level = BuildingParser.parse(args[BOARD]);
		} catch (Exception e) {
			Logger.log("File", e.getMessage(), Logger.LEVEL_ERROR);
			return;
		}
		BuildingProblem problemBuilder = getProblemBuilders(DEFAULT_BUILDER, level);
		setDesiredHeursitic(problemBuilder, args[HEURISTIC].toLowerCase());
		long initialTime = System.currentTimeMillis();

		String alg = args[ALGORITHM].toLowerCase();
		SearchStrategy searchStrategy = null;
		if (alg.equals("bfs") ) {
		  searchStrategy = SearchStrategy.BFS;
		} else if ( alg.equals("idfs") ) {
      searchStrategy = SearchStrategy.IterativeDepth;
		}  else if ( alg.equals("astar") ) {
      searchStrategy = SearchStrategy.AStar;
    }  else if ( alg.equals("greedy") ) {
      searchStrategy = SearchStrategy.Greedy;
    }  else if ( alg.equals("dfs") ) {
      searchStrategy = SearchStrategy.DFS;
    }

		G4GPSEngine engine = new G4GPSEngine();
    engine.engine(problemBuilder, searchStrategy);

		long elapsedTime = System.currentTimeMillis() - initialTime;
		printFormattedElapsedTime(elapsedTime);
	}
	
	private static void printUsage() {
		System.out.println("Usage:");
		System.out.println("\t=> Algorithm:\t\t" + "[BFS | DFS | IDFS | HIDFS | AStar | Greedy]");
		System.out.println("\t=> Board:\t\t" + "res/boards/*");
		System.out.println("\t=> Board iterator:\t" + "[Outspiral | Inspiral | MRV | Sequential]");
		System.out.println("\t=> Heuristic:\t\t" + "[Simple | HighRes | LowRes | No]");
		System.out.print("\t=> Logging level:\t" + "[Min | Med | Max]");
		System.out.println(" -- ** High logging level may reduce performance **");
	}
	
	private static void printFormattedElapsedTime(long elapsedTime) {
		long ms = elapsedTime % 1000;
		long seconds = (elapsedTime / 1000) % 60;
		long minutes = elapsedTime / (60 * 1000);
		String time = "Algorithm took " ;
		if (minutes != 0) {
			time += minutes + " min ";
		}
		time += seconds + " seconds and " + ms + " ms";
		Logger.log("Timing", time, Logger.LEVEL_TRACE);
		System.out.println(time);
	}
	
	private static void initLogger(String logParameter) {
		Map<String, Integer> loggerLevels = new HashMap<String, Integer>();
		loggerLevels.put("off", Logger.LEVEL_OFF);
		loggerLevels.put("low", Logger.LEVEL_ERROR);
		loggerLevels.put("med", Logger.LEVEL_TRACE);
		loggerLevels.put("max", Logger.LEVEL_DEBUG);
		Logger.init();
		Integer level = loggerLevels.get(logParameter);
		if (level == null) {
			System.out.println("Unknown logging level: " + logParameter + ". Using Default intead.");
			level = loggerLevels.get(DEFAULT_LOG_LEVEL);
		}
		Logger.LOG_LEVEL = level;
	}
	
	private static void initBoardIteratorStrategy(String boardStrategy) {
		Map<String, BoardIteratorStrategy> boardStrategies = new HashMap<String, BoardIteratorStrategy>();
		boardStrategies.put("mrv", new MRVStrategy());
		boardStrategies.put("outspiral", new SpiralStrategy(true));
		boardStrategies.put("inspiral", new SpiralStrategy(false));
		boardStrategies.put("sequential", new SequenceStrategy());
		Settings.strategy = boardStrategies.get(boardStrategy);
		if (Settings.strategy == null) {
			throw new IllegalArgumentException("Invalid strategy: " + boardStrategy);
		}
	}
		
	private static GPSEngine initGPS(String algorithm) {
		Map<String, GPSEngine> engines = new HashMap<String, GPSEngine>();
		/*engines.put("dfs", new BuildingsDFSEngine());
		engines.put("bfs", new BuildingsBFSEngine());
		engines.put("idfs", new BuildingsIDFSEngine());
		engines.put("hidfs", new BuildingsHybridIDFSEngine());
		engines.put("astar", new BuildingsAStarEngine());
		engines.put("greedy", new BuildingsGreedyEngine());*/
		GPSEngine gps = engines.get(algorithm);
		if (gps == null) {
			String error = algorithm + " algorithm not found";
			Logger.log("Solver", error, Logger.LEVEL_ERROR);
			throw new IllegalArgumentException(error);
		}
		return gps;
	}
	
	private static BuildingProblem getProblemBuilders(String builder, Board level) {
		Map<String, BuildingProblem> builders = new HashMap<String, BuildingProblem>();
		builders.put("std", new BuildingProblem(level));
		builders.put("red", new BuildingProblem2(level));
		BuildingProblem problemBuilder = builders.get(builder); 
		if (problemBuilder == null) {
			throw new IllegalArgumentException("Unknown " + builder + " type");
		}
		return problemBuilder;
	}
	
	private static void setDesiredHeursitic(BuildingProblem problem, String heuristic) {
		Map<String, Heuristic> heuristics = new HashMap<String, Heuristic>();
		heuristics.put("highres", new HighRestrictionDensityHeuristic());
		heuristics.put("lowres", new LowRestrictionDensityHeuristic());
		heuristics.put("simple", new SimpleHeuristic());
		heuristics.put("no", new NoHeuristic());
		Heuristic h = heuristics.get(heuristic);
		if (h == null) {
			String error = heuristic + " was not found.";
			Logger.log("Heuristic", error, Logger.LEVEL_ERROR);
			throw new IllegalArgumentException(error);
		}
		problem.setHeuristic(h);
	}
}
