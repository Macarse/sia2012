package g4.heuristics;

import gps.api.GPSState;

public interface Heuristic {

  float getValue(GPSState state);

}
