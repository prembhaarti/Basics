package basics.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import basics.linkedlist.LNode;
import basics.linkedlist.Ll;

/**
 * Given n no. of sorted Linkedlist, with their heads in the arraylist.
 * Need to merge them in sorted new LinkedList.
 *
 * Create a min basics.heap.
 * make a for loop from arraylist, take each basics.linkedlist head and add in basics.heap
 *
 * create a new result node
 *
 * take one element out of basics.heap and add in result node and result=result.next
 * now check if that element has next node ->null
 * if not node=node.next and add in min basics.heap
 *
 * return head of result node.
 */
public class MergeKList {

    public LNode merge(List<LNode> list){
      PriorityQueue<LNode> minHeap = new PriorityQueue(list.size(),new LNodeComparator());
      for (LNode node : list) {
        if (node != null) {
          minHeap.add(node);
          node=node.next;
        }
      }
      LNode head = new LNode(-1);
      LNode temp=head;
      while(!minHeap.isEmpty()){
        LNode min=minHeap.poll();
        temp.next=min;
        temp=temp.next;
        if(min.next!=null) minHeap.offer(min.next);
      }
      return head.next;
    }

  public static void main(String[] args) {
    LNode node1 = new LNode(1);
    node1.next=new LNode(4);
    node1.next.next = new LNode(7);

    LNode node2 = new LNode(3);
    node2.next=new LNode(6);
    node2.next.next = new LNode(9);

    LNode node3 = new LNode(8);
    node3.next=new LNode(10);
    node3.next.next = new LNode(11);
    List<LNode> list = new ArrayList<>();
    list.add(node1);
    list.add(node2);
    list.add(node3);

    MergeKList mkl= new MergeKList();
    LNode sorted = mkl.merge(list);

    Ll ll = new Ll();
    ll.display(sorted);
  }
}

class LNodeComparator implements Comparator<LNode>{

  @Override
  public int compare(LNode first, LNode second) {
    return first.data-second.data;
  }
}
