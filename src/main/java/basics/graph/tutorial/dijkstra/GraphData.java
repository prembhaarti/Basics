package basics.graph.tutorial.dijkstra;

import java.util.List;
import java.util.Map;

public class GraphData {

	private Vertex source;
	private Map<String, Vertex> vertexMap;
	private List<Edge> edgeList;

	public GraphData(Vertex source, Map<String, Vertex> vertexMap, List<Edge> edgeList) {
		this.source = source;
		this.vertexMap = vertexMap;
		this.edgeList = edgeList;
	}

	public Vertex getSource() {
		return source;
	}

	public void setSource(Vertex source) {
		this.source = source;
	}

	public Map<String, Vertex> getVertexMap() {
		return vertexMap;
	}

	public void setVertexMap(Map<String, Vertex> vertexMap) {
		this.vertexMap = vertexMap;
	}

	public List<Edge> getEdgeList() {
		return edgeList;
	}
}
