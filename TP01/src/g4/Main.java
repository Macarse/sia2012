package g4;

import gps.SearchStrategy;

import com.g7.JarsProblem;
import com.g7.JarsState;

public class Main {

  public static void main(String[] args) {
    JarsState.STEP = 0;
    System.out.println("Iterative Depth");

    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(new JarsProblem(), SearchStrategy.IterativeDepth);
  }

}
