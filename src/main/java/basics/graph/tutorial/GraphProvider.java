package basics.graph.tutorial;

import basics.graph.grph.Vertex;
import basics.graph.tutorial.dijkstra.GraphData;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphProvider {

	public static List<basics.graph.tutorial.topological.sort.Vertex> getTopoGraphVertices(){

		basics.graph.tutorial.topological.sort.Vertex zero = new basics.graph.tutorial.topological.sort.Vertex("0");
		basics.graph.tutorial.topological.sort.Vertex one = new basics.graph.tutorial.topological.sort.Vertex("1");
		basics.graph.tutorial.topological.sort.Vertex two = new basics.graph.tutorial.topological.sort.Vertex("2");
		basics.graph.tutorial.topological.sort.Vertex three = new basics.graph.tutorial.topological.sort.Vertex("3");
		basics.graph.tutorial.topological.sort.Vertex four = new basics.graph.tutorial.topological.sort.Vertex("4");
		basics.graph.tutorial.topological.sort.Vertex five = new basics.graph.tutorial.topological.sort.Vertex("5");
		three.addNeighbour(one);
		four.addNeighbour(one);
		four.addNeighbour(two);
		five.addNeighbour(zero);
		five.addNeighbour(two);
		two.addNeighbour(three);

		List<basics.graph.tutorial.topological.sort.Vertex> topoVertexList = Arrays.asList(zero, one, two, three, four, five);

		return topoVertexList;
	}
	
	public static basics.graph.tutorial.dijkstra.GraphData getDikstraGraph(){
		basics.graph.tutorial.dijkstra.Vertex a = new basics.graph.tutorial.dijkstra.Vertex("A");
		basics.graph.tutorial.dijkstra.Vertex b = new basics.graph.tutorial.dijkstra.Vertex("B");
		basics.graph.tutorial.dijkstra.Vertex c = new basics.graph.tutorial.dijkstra.Vertex("C");
		basics.graph.tutorial.dijkstra.Vertex d = new basics.graph.tutorial.dijkstra.Vertex("D");
		basics.graph.tutorial.dijkstra.Vertex e = new basics.graph.tutorial.dijkstra.Vertex("E");
		basics.graph.tutorial.dijkstra.Vertex f = new basics.graph.tutorial.dijkstra.Vertex("F");
		basics.graph.tutorial.dijkstra.Vertex g = new basics.graph.tutorial.dijkstra.Vertex("G");
		basics.graph.tutorial.dijkstra.Vertex h = new basics.graph.tutorial.dijkstra.Vertex("H");

		Map<String, basics.graph.tutorial.dijkstra.Vertex> vertexMap = new HashMap<>();
		vertexMap.put("A", a);
		vertexMap.put("B", b);
		vertexMap.put("C", c);
		vertexMap.put("D", d);
		vertexMap.put("E", e);
		vertexMap.put("F", f);
		vertexMap.put("G", g);
		vertexMap.put("H", h);


		basics.graph.tutorial.dijkstra.Edge ab = new basics.graph.tutorial.dijkstra.Edge(5, a, b);
		basics.graph.tutorial.dijkstra.Edge ah = new basics.graph.tutorial.dijkstra.Edge(8, a, h);
		basics.graph.tutorial.dijkstra.Edge ae = new basics.graph.tutorial.dijkstra.Edge(9, a, e);
		basics.graph.tutorial.dijkstra.Edge bd = new basics.graph.tutorial.dijkstra.Edge(15, b, d);
		basics.graph.tutorial.dijkstra.Edge bc = new basics.graph.tutorial.dijkstra.Edge(12, b, c);
		basics.graph.tutorial.dijkstra.Edge bh = new basics.graph.tutorial.dijkstra.Edge(4, b, h);
		basics.graph.tutorial.dijkstra.Edge hc = new basics.graph.tutorial.dijkstra.Edge(7, h, c);
		basics.graph.tutorial.dijkstra.Edge hf = new basics.graph.tutorial.dijkstra.Edge(6, h, f);
		basics.graph.tutorial.dijkstra.Edge eh = new basics.graph.tutorial.dijkstra.Edge(5, e, h);
		basics.graph.tutorial.dijkstra.Edge ef = new basics.graph.tutorial.dijkstra.Edge(4, e, f);
		basics.graph.tutorial.dijkstra.Edge eg = new basics.graph.tutorial.dijkstra.Edge(20, e, g);
		basics.graph.tutorial.dijkstra.Edge fc = new basics.graph.tutorial.dijkstra.Edge(1, f, c);
		basics.graph.tutorial.dijkstra.Edge fg = new basics.graph.tutorial.dijkstra.Edge(13, f, g);
		basics.graph.tutorial.dijkstra.Edge cd = new basics.graph.tutorial.dijkstra.Edge(3, c, d);
		basics.graph.tutorial.dijkstra.Edge cg = new basics.graph.tutorial.dijkstra.Edge(11, c, g);
		basics.graph.tutorial.dijkstra.Edge dg = new basics.graph.tutorial.dijkstra.Edge(9, d, g);

		a.addNeighbor(ab);
		a.addNeighbor(ah);
		a.addNeighbor(ae);
		b.addNeighbor(bd);
		b.addNeighbor(bc);
		b.addNeighbor(bh);
		h.addNeighbor(hc);
		h.addNeighbor(hf);
		e.addNeighbor(eh);
		e.addNeighbor(ef);
		e.addNeighbor(eg);
		f.addNeighbor(fc);
		f.addNeighbor(fg);
		c.addNeighbor(cd);
		c.addNeighbor(cg);
		d.addNeighbor(dg);


		GraphData graphData = new GraphData(a, vertexMap, Arrays.asList(ab,ah,ae,bd,bc,bh,hc,hf,eh,ef,eg,fc,fg,cd,cg,dg));
		return graphData;
	}

}
