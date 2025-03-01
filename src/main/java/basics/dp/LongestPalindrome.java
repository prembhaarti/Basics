package basics.dp;

import basics.util.CodeUtil;

public class LongestPalindrome {

  /**
   *    B   A   N   A   N   A
   * B  1 | 0 | 0 | 0 | 0 | 0 |
   * A  0 | 1 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 1 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 1 | 0 | 1 |
   * N  0 | 0 | 0 | 0 | 1 | 0 |
   * A  0 | 0 | 0 | 0 | 0 | 1 |
   *
   * i goes down and i+j goes right
   *
   *  first take one lenght for each character in word {B,A,N,A,N,A}
   *      diagonal will filled with 1
   *  take 2 character each then {ba,an,na,an,na}
   *  match every first and last character if matches then it's palindrome if below condition matches:
   *    increment first by one (i+1) and decrement last by 1 (i+j-1)
   *      and check if it was palindrome
   *x`
   *      Ex - ANA
   *     first  A -> A (last)
   *        then check for N -> which is already true
   *
   *      Ex - ANANA
   *     first  A -> A (last)
   *        then check for ANA which is already true
   */
  public int palid(char[] word) {
    int[][] matrix = new int[word.length][word.length];

    int maxLen=0;

    for(int j=0;j<word.length;j++){
      for(int i=0;i+j<word.length;i++){
        if(word[i]==word[i+j]){ // if palindrome found
          if(j<=1) { // this condition matches only for single character palindrome
            matrix[i][i + j] = 1;
            if(j+1>maxLen) maxLen=j+1;
          }
          else{ // this condition comes if palindrome found and trim from start (i+1) and last (i+j-1) and check if that was palindrome
            if(matrix[i+1][i+j-1]==1){
              matrix[i][i + j] = 1; // if after trimming it was palindrome then make this palindrome
              if(j+1>maxLen) maxLen=j+1; // check if this palindrome length is greater and set it.
            }
          }
        }
      }
    }

    CodeUtil.display2dMatrix(matrix);
    return maxLen;
  }

  public static void main(String[] args) {
    LongestPalindrome lp = new LongestPalindrome();
    System.out.println("Longest Palindrome:"+lp.palid("banana".toCharArray()));
    System.out.println("Longest Palindrome:"+lp.palid("aa".toCharArray()));
  }
}
