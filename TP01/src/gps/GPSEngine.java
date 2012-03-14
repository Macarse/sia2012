package gps;

import g4.MahjongGPSState;
import gps.api.GPSProblem;
import gps.api.GPSRule;
import gps.api.GPSState;
import gps.exception.NotAppliableException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class GPSEngine {
  private static final long TIME_LIMIT = 1000 * 60 * 5;

	protected List<GPSNode> open = new LinkedList<GPSNode>();

	protected List<GPSNode> closed = new ArrayList<GPSNode>();

	protected GPSProblem problem;

	protected GPSNode rootNode;

	// Use this variable in the addNode implementation
	protected SearchStrategy strategy;

  public void engine(GPSProblem myProblem, SearchStrategy myStrategy) {
    problem = myProblem;
    strategy = myStrategy;

    rootNode = new GPSNode(problem.getInitState(), 0);
    boolean finished = false;
    boolean failed = false;
    boolean timeUp = false;
    long start = System.currentTimeMillis();
    long explosionCounter = 0;
    GPSNode currentNode = null;

    open.add(rootNode);
    while (!failed && !finished && !timeUp) {
      if (open.size() <= 0) {
        failed = true;
      } else {
        currentNode = open.get(0);
        closed.add(currentNode);
        open.remove(0);
        if (isGoal(currentNode)) {
          finished = true;
          System.out.println(currentNode.getSolution());
          currentNode.printDiff();
          System.out.println("solution height: " + currentNode.getHeight(0));
          System.out.println("opened size: " + open.size());
          System.out.println("closed size: " + closed.size());
          System.out.println("Expanded nodes: " + explosionCounter);
        } else {
          explosionCounter++;
          explode(currentNode);
        }
      }

      if ( (System.currentTimeMillis() - start) >= TIME_LIMIT ) {
        timeUp = true;
      }
    }

    if (finished) {
      System.out.println("time: " + (System.currentTimeMillis() - start));
      System.out.println("OK! solution found!");
    } else if (failed) {
      System.err.println("FAILED! solution not found!");
    } else if (timeUp) {
      System.err.println("Time's up!");
      System.out.println("opened size: " + open.size());
      System.out.println("closed size: " + closed.size());
      System.out.println("Expanded nodes: " + explosionCounter);
    }
      
  }

	private  boolean isGoal(GPSNode currentNode) {
		return currentNode.getState() != null
				&& currentNode.getState().compare(problem.getGoalState());
	}

	private  boolean explode(GPSNode node) {

		MahjongGPSState state = (MahjongGPSState) node.getState();
		System.out.println("Payers Count: " + state.getBoard().getPayersCount() + 
		    " Tiles Count: " + state.getBoard().getTilesCount()
		    );

		for (GPSRule rule : problem.getRules(node.getState())) {
			GPSState newState = null;
			try {
				newState = rule.evalRule(node.getState());
			} catch (NotAppliableException e) {
				// Do nothing
			}
			if (newState != null
					&& !checkBranch(node, newState)
					&& !checkOpenAndClosed(node.getCost() + rule.getCost(),
							newState)) {
				GPSNode newNode = new GPSNode(newState, node.getCost()
						+ rule.getCost());
				newNode.setParent(node);
				addNode(newNode);
			}
		}
		return true;
	}

	private  boolean checkOpenAndClosed(Integer cost, GPSState state) {
		for (GPSNode openNode : open) {
			if (openNode.getState().compare(state) && openNode.getCost() < cost) {
				return true;
			}
		}
		for (GPSNode closedNode : closed) {
			if (closedNode.getState().compare(state)
					&& closedNode.getCost() < cost) {
				return true;
			}
		}
		return false;
	}

	private  boolean checkBranch(GPSNode parent, GPSState state) {

		if (parent == null) {
			return false;
		}
		return checkBranch(parent.getParent(), state)
				|| state.compare(parent.getState());
	}

	public abstract void addNode(GPSNode node);

}

