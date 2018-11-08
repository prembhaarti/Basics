package basics.dp;

import basics.util.CodeUtil;

public class SumSubSet {

  /**
   * input={1,2,3,6}
   * sum = 7
   *
   * first fill first column to true coz with any
   * with any input data 0 can be achieved.
   *
   *  if input element less than sum then put above result
   *  if input element equals sum, put above result -> true
   *  if sum exceeds input element -> subtract input from sum and go one above row and
   *  check if it's true.
   *
   *
   *    0 | 1 | 2 | 3 | 4 | 5 | 6 | 7
   * 0  ToString | F | F | F | F | F | F | F
   * 1  ToString | ToString | F | F | F | F | F | F
   * 2  ToString | ToString | ToString | ToString | F | F | F | F
   * 3  ToString | ToString | ToString | ToString | ToString | ToString | ToString | F
   * 6  ToString | ToString | ToString | ToString | ToString | ToString | ToString | ToString
   *
   * result = true
   */

  public boolean containSubSetOfSum(int[] input, int sum){
    boolean[][] matrix = new boolean[input.length+1][sum+1];

    for(int j=0;j<=input.length;j++){
      matrix[j][0]=true;
    }

    for(int j=1;j<=input.length;j++){
      for(int i=1;i<=sum;i++){
        if(i<input[j-1]){
          matrix[j][i]=matrix[j-1][i];
        }
        else{
          if(i==input[j-1]){
            matrix[j][i]=true;
          }
          else{
            if(matrix[j-1][i-input[j-1]]){
              matrix[j][i]=true;
            }
          }
        }
      }
    }
    CodeUtil.display2dMatrix(matrix);
    return matrix[input.length][sum];
  }

  public static void main(String[] args) {
    int[] input={1,2,3,6};
    SumSubSet sss= new SumSubSet();
    System.out.println(sss.containSubSetOfSum(input,7));
  }

}
