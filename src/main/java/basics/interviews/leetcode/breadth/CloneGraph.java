package basics.interviews.leetcode.breadth;// Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.

// OJ's undirected graph serialization:
// Nodes are labeled uniquely.

// We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
// As an example, consider the serialized graph {0,1,2#1,2#2,2}.

// The graph has a total of three nodes, and therefore contains three parts as separated by #.

// First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
// Second node is labeled as 1. Connect node 1 to node 2.
// Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
// Visually, the graph looks like the following:

//        1
//       / \
//      /   \
//     0 --- 2
//          / \
//          \_/

import basics.leetcode.UndirectedGraphNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public HashMap<Integer, UndirectedGraphNod> map = new HashMap<Integer, UndirectedGraphNod>();
    
    public UndirectedGraphNod cloneGraph(UndirectedGraphNod node) {
        if(node == null) {
            return null;
        }
        
        if(map.containsKey(node.label)) {
            return map.get(node.label);
        }
        
        UndirectedGraphNod newNode = new UndirectedGraphNod(node.label);
        map.put(newNode.label, newNode);
        
        for(UndirectedGraphNod neighbor : node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbor));
        }
        
        return newNode;
    }
}

class UndirectedGraphNod {
   public int label;
      public List<UndirectedGraphNod> neighbors;
      public UndirectedGraphNod(int x) { label = x; neighbors = new ArrayList<>(); }
  }
