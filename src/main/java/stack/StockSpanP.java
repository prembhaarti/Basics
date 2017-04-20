package stack;

import java.util.Stack;

/**
 *  stock price array: {100,60,70,60,75,85}
 *  result array :     {1,  1, 2, 1, 4, 5 }
 *
 *  Need to check from present day how many stocks are equal or larger than past stock prices
 *
 */
public class StockSpanP {


  public int[] ssp(int[] stock){
    int result[] = new int[stock.length];
    Stack<Integer> stack = new Stack<>();
    stack.push(0);
    result[0]=1;
    for(int i=1;i<stock.length;i++) {
      if(stock[i]<stock[stack.peek()]){
        result[i]=i-stack.peek();
      }
      else {
        while (!stack.isEmpty() && stock[i] > stock[stack.peek()]) {
          stack.pop();
        }
        result[i]=i-stack.peek();
      }
      stack.push(i);
    }

    return result;
  }

  // {1,  1, 2, 1, 4, 5 }
  // {100,60,70,60,75,85}
  public static void main(String[] args) {
    int[] nums= {100,60,70,60,75,85};
    //          {1,  1, 2, 1, 4, 5 }
    StockSpanP stockSpanP = new StockSpanP();
    int[] result= stockSpanP.ssp(nums);
    for(int i=0;i<result.length;i++){
      System.out.print(result[i]+", ");
    }
  }
}
