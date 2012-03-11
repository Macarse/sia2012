package g4;

import g4.layout2.Layout2Problem;
import g4.layout3.Layout3Problem;
import gps.SearchStrategy;

public class Main {

  public static void main(String[] args) {
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new Layout2Problem(), SearchStrategy.DFS);
  }

}
