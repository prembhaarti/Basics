package basics.graph.tutorial.topological.sort;

import basics.graph.tutorial.GraphProvider;

import java.util.List;
import java.util.Stack;

public class TopologicalOrder {

	private static Stack<Vertex> stack;


	public static void topoSort(){
		Stack<Vertex> sortedVertices = getTopoStack(GraphProvider.getTopoGraphVertices());
		System.out.println(sortedVertices);
	}


	public static Stack<Vertex> getTopoStack(List<Vertex> vertexList){
		createEmptyStack();

		for(Vertex vertex: vertexList){
			if(!vertex.isVisited()){
				dfs(vertex);
			}
		}
		return stack;
	}

	public static void createEmptyStack(){
		stack = new Stack<>();
	}

	public static void dfs(Vertex vertex){
		vertex.setVisited(true);
		List<Vertex> neighbours = vertex.getNeighbourList();
		for(Vertex neighbour: neighbours){
			if(!neighbour.isVisited()) {
				dfs(neighbour);
			}
		}
		stack.push(vertex);
	}
}
