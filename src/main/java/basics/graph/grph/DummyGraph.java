package basics.graph.grph;

public class DummyGraph {

	public static void main(String[] args) {



	}

	public static Vertex getGraphRoot(){
		Vertex root = new Vertex(3);
		Vertex _5 = new Vertex(5);
		Vertex _6 = new Vertex(6);
		Vertex _4 = new Vertex(4);
		Vertex _0 = new Vertex(0);
		Vertex _1 = new Vertex(1);
		Vertex _2 = new Vertex(2);

		_5.getNeighbours().add(_4);
		_5.getNeighbours().add(_6);
		root.getNeighbours().add(_5);
		_1.getNeighbours().add(_0);
		_1.getNeighbours().add(_2);
		root.getNeighbours().add(_1);
		return root;
	}
}
