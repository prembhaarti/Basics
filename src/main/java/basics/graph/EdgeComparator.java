package basics.graph;

import java.util.Comparator;

public class EdgeComparator implements Comparator<Edge> {
  @Override
  public int compare(Edge edge1, Edge edge2) {
    if(edge1.getCost()>=edge2.getCost()){
      return 1;
    }
    return -1;
  }
}
