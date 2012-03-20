package g4.parseLine;

import g4.heuristics.BiggerRowsFirst;
import g4.heuristics.HStar;
import g4.heuristics.Heuristic;
import g4.heuristics.MorePayers;
import g4.heuristics.UpperLevelFirst;

public class HeuristicFactory {
	
	public static Heuristic createHeuristicFromString(String heuristic){
		if( heuristic == null){
			return null;
		}
		if(heuristic.compareToIgnoreCase("BIGGERROWSFIRST") == 0){
			return new BiggerRowsFirst();
		}if(heuristic.compareToIgnoreCase("MOREPAYERS") == 0){
			return new MorePayers();
		}if(heuristic.compareToIgnoreCase("UPPERLEVELFIRST") == 0){
			return new UpperLevelFirst();
		}if(heuristic.compareToIgnoreCase("HSTAR") == 0){
			return new HStar();
		}
		return null;
	}
	

}
