package basics.graph;

import java.util.HashMap;
import java.util.Map;

import basics.interview.graph.BinaryMinHeap;

/**
 *
 * From single source node finds shortest paths
 *      to all other nodes in the basics.graph, producing a shortest-path basics.tree.
 *
 *  # basics.graph should be -> directed or undirected but having non-negative weight
 *  # Implementation using min priority queue :: O(|E|+|V|log|V|)
 *  This shortest path algorithm is widely used in network routing protocols
 *
 *  a source vertex and basics.graph will be given for dijkstra
 *
 *  create a binaryMinHeap and add all vertices with Integer.Max as key and val-> vertices
 *
 *  keep a map of distance (key-> vertices, value -> distance)
 *  keep a map of parents (key-> vertices, value-> partent vertices)
 *
 *  first, decrease value of source vertex to zero in minHeap
 *  put distance of source -> 0 in map
 *  put parent of source -> null in map
 *
 * So, till now we have least distance of source.
 *
 * do the following until minHeap -> Empty
 *
 *  Extract minNode from minHeap
 *    it'll give you node with least weight i.e. initially you get source (0 weight)
 *      let's say this node currentMin.
 *
 *  get currentMinVertex from currentMin
 *    get all edges from currentMinVertex.
 *      from each edge get it's another vertex connected to current
 *        calculate newDistance= currentMinVertex's weight + edgeCost
 *        if newDistance weight is less than minHeap weight update in minHeap
 *        and set it's parent to currentMinVertex.
 *
 *  repeat
 */
public class Dijkstra<T> {

  public Map<Vertex<T>,Integer> shortPath(Graph<T> graph, Vertex<T> source){
    BinaryMinHeap<Vertex<T>> minHeap = new BinaryMinHeap<>();
    Map<Vertex<T>, Integer> distance = new HashMap<>();
    Map<Vertex<T>, Vertex<T>> parents = new HashMap<>();

    for(Vertex v:graph.getVertexList().values()){
      minHeap.add(Integer.MAX_VALUE,v);
    }

    minHeap.decrease(source,0);
    distance.put(source,0);
    parents.put(source, null);

    while(!minHeap.empty()){
      BinaryMinHeap<Vertex<T>>.Node currentMin=minHeap.extractMinNode();
      Vertex<T> current=currentMin.getKey();
      distance.put(current, currentMin.getWeight());
      for(Edge<T> edge:current.getEdges()){
        Vertex<T> adjacent= getAdjacent(edge, current);

        if(!minHeap.containsData(adjacent)){
          continue;
        }

        int newDistance= currentMin.getWeight()+edge.getCost();
        if (newDistance < minHeap.getWeight(adjacent)) {
          minHeap.decrease(adjacent,newDistance);
          parents.put(adjacent, current);
        }
      }
    }
      return distance;
  }

  public Vertex<T> getAdjacent(Edge<T> edge, Vertex<T> current){
     return edge.getFrom().getId()==current.getId()? edge.getTo():edge.getFrom();
  }

  public static void main(String args[]){
    Graph<Integer> graph = new Graph<>(false);
        /*basics.graph.addEdge(0, 1, 4);
        basics.graph.addEdge(1, 2, 8);
        basics.graph.addEdge(2, 3, 7);
        basics.graph.addEdge(3, 4, 9);
        basics.graph.addEdge(4, 5, 10);
        basics.graph.addEdge(2, 5, 4);
        basics.graph.addEdge(1, 7, 11);
        basics.graph.addEdge(0, 7, 8);
        basics.graph.addEdge(2, 8, 2);
        basics.graph.addEdge(3, 5, 14);
        basics.graph.addEdge(5, 6, 2);
        basics.graph.addEdge(6, 8, 6);
        basics.graph.addEdge(6, 7, 1);
        basics.graph.addEdge(7, 8, 7);*/

    graph.addEdge(1, 2, 5);
    graph.addEdge(2, 3, 2);
    graph.addEdge(1, 4, 9);
    graph.addEdge(1, 5, 3);
    graph.addEdge(5, 6, 2);
    graph.addEdge(6, 4, 2);
    graph.addEdge(3, 4, 3);
    Dijkstra<Integer> dijkstra = new Dijkstra();
    Vertex<Integer> sourceVertex= graph.getVertex(1);
    Map<Vertex<Integer>,Integer> distance = dijkstra.shortPath(graph, sourceVertex);
    for(Vertex<Integer> vertex:distance.keySet()){
      System.out.println(vertex.getId()+":"+distance.get(vertex));
    }
  }
}
