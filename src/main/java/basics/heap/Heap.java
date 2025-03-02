package basics.heap;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Heap uses basics.array or list data structure:
 * but it's use is like balanced binary basics.tree
 *
 * Binary basics.heap : MaxHeap ( root is max), MinHeap (root is min).
 *
 * Add: add element at end and bottom-up heapify
 * delete: 1. copy last element of basics.heap to pos (root) which have to be deleted.
 *         2. do topDownHeapify :
 *            we are removing root, so swap root with last element, and decrease list size by 1
 *            now, last element on root, check it's left and right child which is bigger,
 *            swap root with it, and do it recursively every time check if child is in size limit
 *
 * Heap is a special case of balanced binary basics.tree data structure
 * where the root-node key is compared with its children and arranged accordingly
 */

public class Heap {

  public int[] array= {1,3,5,7,9,11,13,15,17,19,21};
    public static List<Integer> heap= new ArrayList<>();

  public static void main(String[] args) {
    Heap hb= new Heap();
    for(int element: hb.array){
      hb.insert(element);
      System.out.println(hb.heap.toString());
    }

    System.out.println("Deleting root");
    hb.delete(0);
    System.out.println(hb.heap);

    hb.sort(hb.heap);
    System.out.println("After basics.heap sort:"+hb.heap);
  }

  public void insert(int element){
        heap.add(element);
        heapify(heap.size()-1);
      }

  /**
    does bottom to up heapify used while inserting element
   1. Add new element and get it's parent
   2. if it's parent is larger than child -> do 3
   3. then swap with parent
   */
  public void heapify(int pos) {
    if(pos>0) {
      int parent_pos = getParent(pos);
      if (heap.get(parent_pos) < heap.get(pos)) {
        swap(parent_pos,pos);
        heapify(parent_pos);
      }
    }
  }

  /**
   * 1. copy last element of basics.heap to pos (root) which have to be deleted.
   * 2. do topDownHeapify
   */
  public void delete(int pos){
    heap.set(pos,heap.get(heap.size()-1));
    heap.remove(heap.size()-1);
    topDownHeapify(pos,heap.size()-1);
}

  /**
   * 1. get leftChild and right Child position of given position
   * 2. check if leftChild and right child position are in limit of given size of basics.heap -> do 3,4
   * 3. if both are in limit, check leftChild value or rightChild value is greater
   * 4. swap with parent with the larger child if larger child is greater than root
   * 5. do recursion
   * 6. if leftChild only in limit then do recursion with pos=leftChild
   * 7. if rightChild only in limit then do recursion with pos=rightChild
   */
  public static void topDownHeapify(int pos , int size){
    if((!(pos <0)&& size>1)){  //pos not less than 0 and size more than 1
      int leftChildPos = 2 * pos + 1;
      int rightChildPos = 2 * pos + 2;
      if(leftChildPos<size && rightChildPos < size) { //childs should be under size limit
            if(heap.get(leftChildPos)>heap.get(rightChildPos)){//checking larger child
              if(heap.get(pos)<heap.get(leftChildPos)){ //swap root with leftChild (larger)
                swap(pos,leftChildPos);
                pos=leftChildPos;
              }
            }
            else{
                swap(pos,rightChildPos);
                pos=rightChildPos;
            }
            topDownHeapify(pos,size);
        }
        else if(leftChildPos< size){ //when only left child is available
          swap(pos,leftChildPos);
          topDownHeapify(leftChildPos,size);
        }
        else if(rightChildPos < size){ //when only right child is available.
          swap(pos,rightChildPos);
          topDownHeapify(rightChildPos,size);
        }
      }
  }

  /**
   * 1. swap root value to basics.heap's last position
   *    with this largest element will be at last
   * 2. reduce scope of basics.heap size by 1 from last
   * 3. do topToDownHeapify
   * 4. keep doing this until scope of basics.heap size is 1.
   */
  public void sort(List<Integer> heap){
    if(null!=heap && heap.size()>1){
      int heapSize=heap.size()-1;
      while(heapSize>0){
        swap(0,heapSize);
        topDownHeapify(0,--heapSize); // decrease size from end by one each time.
      }
    }
  }

  public int getParent(int pos){
    if(pos%2==0){
      return (pos-2)/2;
    }
    else{
      return (pos-1)/2;
    }
  }

  public static void swap(int a, int b){
    int temp= heap.get(a);
    heap.set(a,heap.get(b));
    heap.set(b,temp);
  }

}