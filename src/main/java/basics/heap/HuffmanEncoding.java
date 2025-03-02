package basics.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Huffman code is a particular type of optimal prefix code that is used for
 * lossless data compression
 *
 * Given characters : {a,b,c,d}
 * their frequency  : {4,3,2,1}
 *
 * Create a code for them:
 * output: {a=0, b=10, c=111, d=110}
 *
 * Create a min basics.heap having huffmanNode{data,freq} based on freq of char
 *
 * Now create sum basics.tree with help of minHeap
 *
 * poll two minimum value from head
 * create a huffman node having frequency sum of two
 *    and its left and right child add polled huffman node
 * Now add this sum huffman node in basics.heap again
 * do it until basics.heap size becomes 1, that'll be root of sum basics.tree
 *
 */
public class HuffmanEncoding<T> {

  public Map<Character,String> encode(Map<T,Integer> inputMap){
    PriorityQueue<HuffmanNode<T>> heap = new PriorityQueue<>(inputMap.size(),new HuffmanNodeComparator<>());

    //adding data in basics.heap
    for(T key:inputMap.keySet()){
       HuffmanNode<T> node = new HuffmanNode();
        node.setData(key);

        node.setFreq(inputMap.get(key));
        heap.offer(node);
    }

    //create huffman sum basics.tree
    /**
     *          10
     *        0 /  \ 1
     *         /    \
     *        4      6
     *            0 / \ 1
     *             /   \
     *            3    3
     *              0 / \ 1
     *               1   2
     *
     *   before going left add zero to stringbuffer, when go right then remove zero from end and add 1
     *   if found left child and right child null
     *            add code against root data in map.
     */
    while(heap.size()>1){
      HuffmanNode node1=heap.poll();
      HuffmanNode node2= heap.poll();
      HuffmanNode sumNode= new HuffmanNode();
      sumNode.setFreq(node1.getFreq()+node2.getFreq());
      sumNode.left=node1;
      sumNode.right=node2;
      heap.offer(sumNode);
    }

    Map<Character,String> result= new HashMap<>();
    HuffmanNode<T> root=heap.poll();
    StringBuffer sb= new StringBuffer();
    generateCode(root,result,sb);
    return result;
  }

  public void generateCode(HuffmanNode<T> root,Map<Character,String> resultMap, StringBuffer sb){
    if(root!=null){
      sb.append("0");
      generateCode(root.left,resultMap,sb);
      sb.deleteCharAt(sb.length()-1);
      sb.append("1");
      generateCode(root.right,resultMap,sb);
      sb.deleteCharAt(sb.length()-1);
      if(root.left==null && root.right==null){
        resultMap.put((Character)root.getData(),sb.toString());
      }
    }
  }

  public static void main(String[] args) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('a',4);
    map.put('b',3);
    map.put('c',2);
    map.put('d',1);
    HuffmanEncoding huff= new HuffmanEncoding();
    Map<Character,String> result=huff.encode(map);
    System.out.println(result);
  }
}

class HuffmanNodeComparator<T> implements Comparator<HuffmanNode<T>> {
  @Override
  public int compare(HuffmanNode<T> node1, HuffmanNode<T> node2) {
    if(node1.getFreq()>=node2.getFreq()){
      return 1;
    }
    else{
      return -1;
    }
  }
}

class HuffmanNode<T> {
  private int freq;
  private T data;
  HuffmanNode<T> left;
  HuffmanNode<T> right;

  public int getFreq() {
    return freq;
  }

  public void setFreq(int freq) {
    this.freq = freq;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }
}