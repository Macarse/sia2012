package g4;

import gps.GPSEngine;
import gps.GPSNode;
import gps.SearchStrategy;
import gps.api.GPSProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import aga.mahjong.core.Board;
import aga.mahjong.core.Pair;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

public class G4GPSEngine extends GPSEngine {
  protected int depthLevel = 72;
  protected int generatedNodes;

  @Override
  public void engine(GPSProblem myProblem, SearchStrategy myStrategy) {
    generatedNodes = 0;
    super.engine(myProblem, myStrategy);
  }

  @Override
  public void addNode(GPSNode node) {
    switch (strategy) {
    case BFS:
      open.add(node);
      break;
    case IterativeDepth:
      if (node.getTreeLevel() > depthLevel + 1) {
        generatedNodes += open.size() + closed.size();
        closed.clear();
        open.clear();
        open.add(rootNode);
        depthLevel++;
        break;
      } else if (node.getTreeLevel() > depthLevel) {
        open.add(node);
        break;
      }
    case DFS2:
    case DFS:
      ((LinkedList<GPSNode>) open).addFirst(node);
      break;
    case AStar:
      int index = Collections.binarySearch(open, node,
          new Comparator<GPSNode>() {

            @Override
            public int compare(GPSNode o1, GPSNode o2) {
              Integer f1 = o1.getCost()
                  + problem.getHValue(o1.getState());
              Integer f2 = o2.getCost()
                  + problem.getHValue(o2.getState());
              if (f1 < f2) {
                return -1;
              } else if (f1 == f2) {
                return 0;
              } else {
                return 1;
              }
            }
          });
      if (index >= 0) {
        ((LinkedList<GPSNode>) open).add(index, node);
      } else {
        ((LinkedList<GPSNode>) open).add(-1 * (index + 1), node);
      }
      break;
    case Greedy:
      if (open.isEmpty()
          || !open.get(0).getParent().equals(node.getParent())) {
        ((LinkedList<GPSNode>) open).addFirst(node);
      } else {
        final GPSNode node2 = node;
        List<GPSNode> openParent = Lists.newArrayList(Collections2
            .filter(open, new Predicate<GPSNode>() {

              @Override
              public boolean apply(GPSNode input) {
                return input.getParent().equals(node2.getParent());
              }
            }));
        int index2 = Collections.binarySearch(openParent, node,
            new Comparator<GPSNode>() {

              @Override
              public int compare(GPSNode o1, GPSNode o2) {
                return problem.getHValue(o1.getState())
                    - problem.getHValue(o2.getState());
              }
            });
        if (index2 >= 0) {
          ((LinkedList<GPSNode>) open).add(index2, node);
        } else {
          ((LinkedList<GPSNode>) open).add(-1 * (index2 + 1), node);
        }
      }
      break;
    default:
      open.add(node);
      break;
    }
  }

  @Override
  protected GPSNode onLeaf(GPSNode node) {
    System.out.println("We have reached a leaf");

    Info info = new Info();
    info.leaf = node;

    info.getParents(node, -1);
    if ( info.root == null ) {
      System.out.println("Not applicable");
      return null;
    }

    List<Pair> rootMoves = info.getRootMoves();

    for (Pair pair : info.moves) {
      rootMoves.remove(pair);
    }

    if ( rootMoves.size() == 0 ) {
      System.out.println("Found a test subject");
      return info.root;
    } else {
      System.out.println("Not applicable: " + rootMoves.size());
      return null;
    }
  }

  private static class Info {
    private GPSNode leaf;
    private GPSNode root;
    private List<Pair> moves = new ArrayList<Pair>();

    public void getParents(GPSNode node, int payersCount) {

      // If we reach the initial node of the problem.
      if (node.getParent() == null) {
        root = node;
        return;
      }

      MahjongGPSState state = (MahjongGPSState) node.getState();
      MahjongGPSState parent = (MahjongGPSState) node.getParent()
          .getState();

      if (state.getBoard().getPayersCount() < payersCount + 1) {
        root = node;
        getParents(node.getParent(), payersCount);
      } else if (state.getBoard().getPayersCount() == payersCount + 1) {
        root = node;
        getParents(node.getParent(), payersCount + 1);
      }

      if ( node != root ) {
        moves.add(Board.getMoveInPair(state.getBoard(),
          parent.getBoard()));
      }

    }

    public List<Pair> getRootMoves() {
      List<Pair> rootMoves = new ArrayList<Pair>();
      MahjongGPSState rootState = (MahjongGPSState) root.getState();

      Pair[] pairs = rootState.getBoard().getPairs();
      for (int i = 0; i < pairs.length; i++) {
        rootMoves.add(pairs[i]);
      }

      return rootMoves;
    }
  }

}
