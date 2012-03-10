package g4;

import g4.layout1.Layout1Problem;
import gps.SearchStrategy;

public class Main {

  public static void main(String[] args) {
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new Layout1Problem(), SearchStrategy.BFS);
  }

}
