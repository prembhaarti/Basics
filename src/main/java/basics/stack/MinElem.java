package basics.stack;

import java.util.Stack;

/**
 * arr -> {4,9,1,7,2,3,5,0,10}
 *
 * insertion of element -> O(1)
 * getting last added element -> O(1)
 * getting minimum element -> O(1)
 *
 * create two basics.stack -> basics.stack and minStack
 *
 * adding:
 *    if basics.stack is empty put element in both
 *    not empty
 *      check if element less than minStack top
 *        push element in both
 *      else
 *        only push in basics.stack
 * removing:
 *    if basics.stack top matches with minStack
 *      remove from both
 *    else only remove from basics.stack
 *
 *    if basics.stack empty return -1
 */

public class MinElem {

   private int[] elements= {4,9,1,7,2,3,5,0,10};

   private Stack<Integer> stack= new Stack<>();
   private Stack<Integer> minStack= new Stack<>();


  public void push(int element){
    stack.push(element);
    if(!minStack.isEmpty()){
      if(element<minStack.peek()){
        minStack.push(element);
      }
    }
    else{
      minStack.push(element);
    }
  }

  public int pop(){
    if(!stack.isEmpty()){
      int removed=stack.pop();
      if(!minStack.isEmpty() && minStack.peek()==removed){
        minStack.pop();
      }
      return removed;
    }
    return -1;
  }

  public int getMin(){
    if(!minStack.isEmpty()){
      return minStack.peek();
    }
    return -1;
  }

  public static void main(String[] args) {
        MinElem minElem = new MinElem();
    for(int i=0;i<minElem.elements.length;i++){
      minElem.push(minElem.elements[i]);
      System.out.println("-"+minElem.getMin());
    }
  }
}