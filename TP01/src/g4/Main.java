package g4;

import g4.layout4.Layout4Problem;
import gps.SearchStrategy;

public class Main {

  public static void main(String[] args) {
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new Layout4Problem(), SearchStrategy.IterativeDepth);
  }

}
