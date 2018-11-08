package basics.graph.grph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	private Queue<Vertex> queue;

	public BFS(Queue<Vertex> queue) {
		queue = new LinkedList<>();
	}

	public void search(Vertex startVertex){
		if(startVertex!=null) {
			startVertex.setVisited(true);
			queue.add(startVertex);

			while (!queue.isEmpty()){
				Vertex vertex = queue.remove();
				System.out.println(vertex.getData());

				List<Vertex> neighbours = vertex.getNeighbours();
				for(Vertex neighbour: neighbours){
					if(!neighbour.isVisited()) {
						neighbour.setVisited(true);
						queue.add(neighbour);
					}
				}
			}
		}
	}
}
