package g4;

import g4.parseLine.CommandLineParser;
import g4.parseLine.ProblemFactory;
import gps.SearchStrategy;
import gps.api.GPSProblem;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main {

	
  public static void main(String[] args) {
	  
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
		
		if(arguments.getStrategy() == null) {
			System.err.println("Es necesario ingresar una estrategia de busqueda");
			parser.printUsage(System.err);
			System.exit(1);
		}
		SearchStrategy strategy = arguments.getStrategy();
		
		GPSProblem problem = ProblemFactory.createProblem(arguments.getLevel());
		
	  
    G4GPSEngine engine = new G4GPSEngine();
    engine.engine(problem, strategy);
  }

}
