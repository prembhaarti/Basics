package stack;

import java.util.Stack;

/**
 * 5+[4*{3+5}/(3*2)+4]
 *
 * above expression has balanced parantheses
 *
 * if found open bracket push in stack
 * if found close ->
 *     return false if stack empty
 *     or popped element is not corresponding open bracket
 *
 * after traversing completion
 * if stack is empty return true
 *
 */
public class BalancedParantheses {

  public boolean isValidExpression(String expression){

    Stack<Character> stack= new Stack<>();
    for(char ch:expression.toCharArray()){
      if(ch=='['||ch=='{'||ch=='('){
        stack.push(ch);
      }
      else if(ch==')'){
        if(stack.isEmpty()||stack.pop()!='(') return false;
      }
      else if(ch=='}'){
        if(stack.isEmpty()||stack.pop()!='{') return false;
      }
      else if(ch==']'){
        if(stack.isEmpty()||stack.pop()!='[') return false;
      }
    }
    if(stack.isEmpty()) return true;

    return false;
  }

  public static void main(String[] args) {
    BalancedParantheses bp= new BalancedParantheses();
    System.out.println(bp.isValidExpression("5+[4*{3+5}/(3*2)+4]"));
  }
}