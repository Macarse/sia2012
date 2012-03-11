package g4;

import g4.layout2.Layout2Problem;
import gps.SearchStrategy;

public class Main {

  public static void main(String[] args) {
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new Layout2Problem(), SearchStrategy.DFS);
  }

}
