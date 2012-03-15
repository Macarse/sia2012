package g4;

import g4.layout3.Layout3Problem;
import gps.SearchStrategy;

public class Main {

  public static void main(String[] args) {
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new Layout3Problem(), SearchStrategy.DFS);
  }

}
