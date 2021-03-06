package gps;

public enum SearchStrategy {
  BFS("BFS"), DFS("DFS"), IterativeDepth("ITERATIVE"),
  AStar("ASTAR"),Greedy("GREEDY");

  public String value;

  private SearchStrategy(String value) {
    this.value = value;
  }

  public static SearchStrategy fromString(String text) {
    if (text != null) {
      for (SearchStrategy s : SearchStrategy.values()) {
        if (text.toUpperCase().equalsIgnoreCase(s.value)) {
          return s;
        }
      }
    }
    return null;
  }

}
