package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Topological sort: O(V+E)
 *    sort in a way that least dependent will come first and most dependent in the last.
 *
 *    get all vertices from graph
 *    create visited list of vertex
 *
 *    create resultList
 *
 *    loop for all vertices
 *      if vertex is not visited
 *        call dfsForTopSort method -> visited, result, vertex
 *          in method
 *            add passed vertex in visited list
 *              get all adjacent vertex from this vertex
 *                if any adjacent vertex not visited call recursively
 *
 *              at end you'll come to leaf node or not dependent vertex when out of loop
 *              add this in result list
 *
 *    It uses DFS algorithm - Stack way
 */
public class TopologicalSort<T> {


  public List<Vertex<T>> topSort(Graph<T> graph){
    List<Vertex<T>> allVertices= new ArrayList<>(graph.getVertexList().values());
    List<Vertex<T>> visited= new ArrayList<>();

    List<Vertex<T>> result= new ArrayList<>();

    for(Vertex vertex: allVertices){
      if(!visited.contains(vertex)){
        dfsForTopSort(visited,result,vertex);
      }
    }
    return result;
  }
  public void dfsForTopSort(List<Vertex<T>> visited, List<Vertex<T>> result, Vertex<T> vertex){
    visited.add(vertex);
    for(Vertex v:vertex.getAdjacencyList()){
      if(!visited.contains(v)){
        dfsForTopSort(visited,result,v);
      }
    }
    result.add(vertex);
  }

  public static void main(String[] args) {

    Graph<Integer> graph = new Graph<>(true);
    graph.addEdge(1, 3);
    graph.addEdge(1, 2);
    graph.addEdge(3, 4);
    graph.addEdge(5, 6);
    graph.addEdge(6, 3);
    graph.addEdge(3, 8);
    graph.addEdge(8, 11);
    TopologicalSort topologicalSort= new TopologicalSort();
    List<Vertex<Integer>> result=topologicalSort.topSort(graph);
    for(int i=result.size()-1;i>=0;i--){
      System.out.println(result.get(i).getId());
    }
  }
}