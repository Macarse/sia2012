package g4.parseLine;

import g4.layout1.Layout1Problem;
import g4.layout2.Layout2Problem;
import g4.layout3.Layout3Problem;
import g4.layout4.Layout4Problem;
import gps.api.GPSProblem;

public class ProblemFactory {
	
	public static GPSProblem createProblem(int level){
		GPSProblem problem = null;
		switch (level) {
		case 1:
			problem = new Layout1Problem();
			break;
		case 2:
			problem = new Layout2Problem();
			break;
		case 3:
			problem = new Layout3Problem();
		case 4:
			problem = new Layout4Problem();

		default:
			break;
		}
		return problem;
	}

}
