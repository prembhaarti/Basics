package basics.graph.tutorial.dijkstra;

public class Edge {
	private double weight;
	private Vertex source;
	private Vertex destination;

	public Edge(double weight, Vertex source, Vertex destination) {
		this.weight = weight;
		this.source = source;
		this.destination = destination;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Vertex getDestination() {
		return destination;
	}

	public void setDestination(Vertex destination) {
		this.destination = destination;
	}
}
