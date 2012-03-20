package g4.parseLine;

import g4.heuristics.Heuristic;
import g4.layouts.layout1.Layout1Problem;
import g4.layouts.layout2.Layout2Problem;
import g4.layouts.layout3.Layout3Problem;
import g4.layouts.layout4.Layout4Problem;
import gps.api.GPSProblem;

public class ProblemFactory {
	
	public static GPSProblem createProblem(int level, Heuristic heuristic){
		GPSProblem problem = null;
		switch (level) {
		case 1:
			problem = new Layout1Problem(heuristic);
			break;
		case 2:
			problem = new Layout2Problem(heuristic);
			break;
		case 3:
			problem = new Layout3Problem(heuristic);
		case 4:
			problem = new Layout4Problem(heuristic);

		default:
			break;
		}
		return problem;
	}

}
