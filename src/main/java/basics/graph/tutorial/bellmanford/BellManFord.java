package basics.graph.tutorial.bellmanford;

import basics.graph.tutorial.GraphProvider;
import basics.graph.tutorial.dijkstra.Edge;
import basics.graph.tutorial.dijkstra.GraphData;
import basics.graph.tutorial.dijkstra.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BellManFord {

	private List<Vertex> vertices;
	private List<Edge> edgeList;

	public BellManFord(List<Vertex> vertices, List<Edge> edgeList) {
		this.vertices = vertices;
		this.edgeList = edgeList;
	}

	public static void main(String[] args) {
		GraphData graphData = GraphProvider.getDikstraGraph();
		BellManFord bellManFord = new BellManFord(new ArrayList<>(graphData.getVertexMap().values()), graphData.getEdgeList());

		bellManFord.bellManFord(graphData.getVertexMap().get("A"));
		for(Vertex vertex: bellManFord.vertices){
			System.out.println("A->"+vertex.getName()+": " +bellManFord.getShortestPath(vertex));
		}

	}

	public void bellManFord(Vertex source) {
		source.setDistance(0);

		for (int vertexCount=0; vertexCount<vertices.size(); vertexCount++) {
			for (Edge edge : edgeList) {
				Vertex u = edge.getSource();
				if (u.getDistance() == Double.MAX_VALUE)
					continue;
				Vertex v = edge.getDestination();

				double newDistance = u.getDistance() + edge.getWeight();
				if (newDistance < v.getDistance()) {
					v.setDistance(newDistance);
					v.setPredecessor(u);
				}

			}
		}

		for (Edge edge : edgeList) {
			if (edge.getSource().getDistance() == Double.MAX_VALUE) {
				continue;
			}
			if (hasCycle(edge)) {
				System.out.println("Negative cycle detected");
			}
		}

	}

	public boolean hasCycle(Edge edge) {
		return edge.getSource().getDistance() + edge.getWeight() < edge.getDestination().getDistance();
	}

	public List<Vertex> getShortestPath(Vertex target){
		List<Vertex> shortestPath = new ArrayList<>();
		while(target.getPredecessor()!=null){
			shortestPath.add(target);
			target = target.getPredecessor();
		}
		return shortestPath;
	}
}
