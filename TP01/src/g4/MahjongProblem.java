package g4;

import java.util.ArrayList;
import java.util.List;

import g4.heuristics.Heuristic;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;

public abstract class MahjongProblem implements GPSProblem {
	
	protected Heuristic heuristic;
	
		
	 @Override
	  public List<GPSRule> getRules(GPSState state) {
	    List<GPSRule> rules = new ArrayList<GPSRule>();

	    final MahjongGPSState gpsState = (MahjongGPSState) state;
	    int count = gpsState.getBoard().getPayersCount();

	    for (int i = 0 ; i < count ; i++ ) {
	      rules.add(new MahjongGPSRule(i));
	    }


	    //Collections.shuffle(rules, new Random(13372));

	    return rules;
	  }

	 public float getHValue(GPSState state1){
		 return heuristic.getValue(state1);
	 }

}
