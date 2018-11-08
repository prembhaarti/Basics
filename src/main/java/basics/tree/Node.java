package basics.tree;

public class Node {
	int data;
	Node rc;
	Node lc;
	Node next;
	int height;

	public Node() {
		// TODO Auto-generated constructor stub
	}

	public Node(int data) {
		this.data = data;
		this.rc = null;
		this.lc = null;
	}

}