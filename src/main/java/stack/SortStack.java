package stack;

import java.util.Stack;

/**
 * Given a stack : [4,3,2,1]
 * you need to sort this stack, can use a temporary stack.
 *
 * traverse until main stack is empty
 *      pop element from mainStack
 *
 *      if temporary stack -> empty
 *          push popElement from mainStack
 *
 *      if tempStack not Empty and poppedElement<tempStack top
 *          pass tempstack element to mainStack
 *          until popped element becomes greater than tempStack top
 *          or tempStack gets empty.
 *
 *      if popped element> tempStack top -> push in tempStack
 *
 * now coz mainStack is Empty
 *      pass all elements in tempStack to MainStack and return
 */

public class SortStack {

    private static Stack<Integer> stack;
    public SortStack(){
        stack= new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
    }

    public Stack<Integer> sortStack(Stack<Integer> mainStack){
        Stack<Integer> tempStack= new Stack<>();

        while(!mainStack.isEmpty()){
            int mainPopped=mainStack.pop();
            if (tempStack.isEmpty()){
                tempStack.push(mainPopped);
            }
            else if(mainPopped<tempStack.peek()){
                while(!tempStack.isEmpty() && mainPopped<tempStack.peek()) {
                    mainStack.push(tempStack.pop());
                }
                tempStack.push(mainPopped);
            }
            else {
                tempStack.push(mainPopped);
            }
        }
        while (!tempStack.isEmpty()) {
            mainStack.push(tempStack.pop());
        }
        return mainStack;
    }

    public static void main(String[] args) {
        Stack<Integer> result=new SortStack().sortStack(stack);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}