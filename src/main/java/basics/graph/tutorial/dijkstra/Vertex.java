package basics.graph.tutorial.dijkstra;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{

	private String name;
	private List<Edge> connectedEdges;
	private double distance;
	private boolean visited;
	private Vertex predecessor;

	public Vertex(String name) {
		this.name = name;
		this.connectedEdges = new ArrayList<>();
		distance = Double.MAX_VALUE;
	}

	public void addNeighbor(Edge neighborEdge){
		connectedEdges.add(neighborEdge);
	}

	public String getName() {
		return name;
	}

	public List<Edge> getConnectedEdges() {
		return connectedEdges;
	}

	public double getDistance() {
		return distance;
	}

	public boolean isVisited() {
		return visited;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setConnectedEdges(List<Edge> connectedEdges) {
		this.connectedEdges = connectedEdges;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	@Override public int compareTo(Vertex o) {
		return (int)(this.distance - o.getDistance());
	}

	@Override public String toString() {
		return this.name;
	}
}
