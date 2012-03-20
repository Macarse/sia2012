package g4;

import g4.heuristics.Heuristic;
import g4.parseLine.CommandLineParser;
import g4.parseLine.HeuristicFactory;
import g4.parseLine.ProblemFactory;
import gps.SearchStrategy;
import gps.api.GPSProblem;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

  public static void main(String[] args) {

    // G4GPSEngine engine = new G4GPSEngine();
    // engine.engine(new Layout4Problem(new HStar()), SearchStrategy.AStar);

    CommandLineParser arguments = new CommandLineParser();
    CmdLineParser parser = new CmdLineParser(arguments);
    try {
      parser.parseArgument(args);
    } catch (CmdLineException e) {
      System.err.println("Parametros invalidos");
      parser.printUsage(System.err);
      System.exit(1);
    }

    if (arguments.help) {
      parser.printUsage(System.out);
      System.exit(1);
    }

    if (arguments.getStrategy() == null) {
      System.err
          .println("Es necesario ingresar una estrategia de busqueda");
      parser.printUsage(System.err);
      System.exit(1);
    }
    if (arguments.getHeuristic() == null
        && arguments.getStrategy() != SearchStrategy.DFS
        && arguments.getStrategy() != SearchStrategy.BFS
        && arguments.getStrategy() != SearchStrategy.IterativeDepth) {
      System.err
          .println("Es necesario ingresar una Heuristica para este algoritmo de busqueda");
      parser.printUsage(System.err);
      System.exit(1);

    }
    Heuristic heuristic = null;
    if (arguments.getStrategy() != SearchStrategy.DFS
        && arguments.getStrategy() != SearchStrategy.BFS
        && arguments.getStrategy() != SearchStrategy.IterativeDepth) {
      heuristic = HeuristicFactory.createHeuristicFromString(arguments
          .getHeuristic());
      if (heuristic == null) {
        System.err
            .println("Error al crear heuristica, vuelva a intentar");
        parser.printUsage(System.err);
        System.exit(1);

      }
    }
    if (arguments.getCost() != null) {
      MahjongGPSRule.setCost(arguments.getCost());
    }
    SearchStrategy strategy = arguments.getStrategy();

    GPSProblem problem = ProblemFactory.createProblem(
        arguments.getLevel(), heuristic);

    if (problem == null) {
      System.err.println("Invalid problem level");
      System.exit(1);
    }
    if (strategy == null) {
      System.err.println("Invalid Strategy");
      System.exit(1);

    }

    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(problem, strategy);

  }

}
