package stack;

import java.util.Stack;


/**
 * arr[]= {3, 2, 1, 4, 5}
 *
 * print each element's next greater element in array.
 *
 * output:
 * Next greater element of1:4
 * Next greater element of2:4
 * Next greater element of3:4
 * Next greater element of4:5
 * Next greater element of 5:-1
 *
 * create a stack
 *
 * start to traverse array
 *  if stack empty or arr[i]< stack top -> push element
 *  if arr[i]> stack top ->
 *      pop element in stack until, stack top is less than arr[i]
 *      or stack becomes empty
 *      then push arr[i] in stack
 *
 *  after array traversed
 *  check if stack is not empty
 *      pop each element and print next greater not exist or -1
 */

public class NextGreaterElement {
//    static int arr[]= {11, 13, 21, 3};
    static int arr[]= {3, 2, 1, 4, 5};

    public static void printNextGreaterElement(int[] arr) {
        if(arr==null||arr.length<1){return;}
        int index=0;
        Stack<Integer> stack = new Stack<>();
        while(index<arr.length) {
            if (stack.isEmpty() || arr[index] < stack.peek()) {
                stack.push(arr[index]);
            } else {
                int smaller=Integer.MIN_VALUE;
                while(!stack.isEmpty() && (smaller=stack.pop())<arr[index]) {
                    System.out.println("Next greater element of" + smaller + ":" + arr[index]);
                }
                stack.push(arr[index]);
            }
            index++;
        }
        while(!stack.isEmpty()){
            System.out.println("Next greater element of "+stack.pop()+":-1");
        }
    }
    public static void main(String[] args) {
        printNextGreaterElement(arr);
    }
}