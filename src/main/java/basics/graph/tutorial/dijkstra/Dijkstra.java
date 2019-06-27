package basics.graph.tutorial.dijkstra;

import basics.graph.tutorial.GraphProvider;

import java.util.*;

public class Dijkstra {

	/**
	 * set source distance -> 0
	 * add source in priority queue
	 *
	 * iterate queue until it's not empty
	 *      get min distance vertex
	 *      get it's all connected edges
	 *          iterate through all edges
	 *              check if edge vertex new distance is less than current distance
	 *                  if true -> set new distance, predecessor and add target in queue
	 *
	 */
	public static void main(String[] args) {
		GraphData graphData = GraphProvider.getDikstraGraph();
		Map<String, Vertex> vertexMap = graphData.getVertexMap();
		computeShortestPaths(graphData.getSource());

		for(Vertex vertex : vertexMap.values()){
			System.out.println(graphData.getSource().getName()+":"+ vertex + "-> " + getShortestPath(vertex));
		}
	}

	public static void computeShortestPaths(Vertex source){
		source.setDistance(0);
		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		queue.add(source);

		while(!queue.isEmpty()) {
			Vertex currentSource = queue.poll();
			for (Edge edge : currentSource.getConnectedEdges()) {
				Vertex target = edge.getDestination();
				double totalDistance = source.getDistance() + edge.getWeight();
				if (totalDistance < target.getDistance()) {
					queue.remove(target);
					target.setDistance(totalDistance);
					target.setPredecessor(currentSource);
					queue.add(target);
				}
			}
		}
	}

	public static List<Vertex> getShortestPath(Vertex target){
		List<Vertex> shortestPath = new ArrayList<>();
		for(Vertex predecessor = target.getPredecessor(); predecessor!=null; predecessor = predecessor.getPredecessor()){
			shortestPath.add(predecessor);
		}

		Collections.reverse(shortestPath);
		return shortestPath;
	}
}
