package gps;

import gps.api.GPSState;

public class GPSNode {

  private GPSState state;

  private GPSNode parent;

  private Integer cost;

  private Integer treeLevel;

  public GPSNode(GPSState state, Integer cost) {
    super();
    this.state = state;
    this.cost = cost;
    this.treeLevel = 0;
  }

  public GPSNode getParent() {
    return parent;
  }

  public void setParent(GPSNode parent) {
    this.parent = parent;
    if (parent != null) {
      this.treeLevel = parent.getTreeLevel() + 1;
    }
  }

  public GPSState getState() {
    return state;
  }

  public Integer getCost() {
    return cost;
  }

  public Integer getTreeLevel() {
    return treeLevel;
  }

  @Override
  public String toString() {
    return state.toString();
  }

  public String getSolution() {
    if (this.parent == null) {
      return this.state.toString();
    }
    return this.parent.getSolution() + "\n" + this.state;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cost == null) ? 0 : cost.hashCode());
    result = prime * result
        + ((parent == null) ? 0 : parent.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    GPSNode other = (GPSNode) obj;
    if (cost == null) {
      if (other.cost != null)
        return false;
    } else if (!cost.equals(other.cost))
      return false;
    if (parent == null) {
      if (other.parent != null)
        return false;
    } else if (!parent.equals(other.parent))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    return true;
  }

}
