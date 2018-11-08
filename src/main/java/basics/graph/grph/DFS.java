package basics.graph.grph;

import java.util.List;
import java.util.Stack;

public class DFS {

	private static Stack<Vertex> stack = new Stack<>();

	public DFS(Stack<Vertex> stack) {
		this.stack = new Stack<>();
	}

	public static void search(Vertex startVertex){
		if(startVertex!=null){
			List<Vertex> neighbours = startVertex.getNeighbours();
			startVertex.setVisited(true);
			System.out.println(startVertex.getData());

			for(Vertex neibhour : neighbours){
				if(!neibhour.isVisited()){
					search(neibhour);
				}
			}
		}
	}

	public static void searchIteration(Vertex startVertex){
		if(startVertex!=null){
			List<Vertex> neighbours = startVertex.getNeighbours();
			stack.push(startVertex);
			startVertex.setVisited(true);

			for(Vertex neibhour : neighbours){
				if(!neibhour.isVisited()){
					search(neibhour);
				}
			}
			System.out.println(stack.pop().getData());
		}
	}

	public static void main(String[] args) {
		Vertex root= DummyGraph.getGraphRoot();
		search(root);

	}
}
