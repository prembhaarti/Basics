package backtraking;

import java.util.Arrays;
import util.CodeUtil;

public class ArrayPermutation {

  /**
   * input : {1,2,3}
   *
   * returns all combination of same length
   * output:
   * [1, 2, 3]
   * [1, 3, 2]
   * [2, 1, 3]
   * [2, 3, 1]
   * [3, 2, 1]
   * [3, 1, 2]
   *
   * pass array and initial position
   *
   * loop for start to end
   *  print when position comes to end of array
   *    swap i with pos -> this will jumble initial chars
   *    pass num,pos+1
   *    swap i with pos again -> this will jumble last chars
   */
  public void numPermutation(int[] nums,int pos){
    for(int i=pos;i<nums.length;i++){
      if(pos==nums.length-1){
        System.out.println(Arrays.toString(nums));
      }
      else {
        CodeUtil.swap(nums, i, pos);
        numPermutation(nums, pos + 1);
        CodeUtil.swap(nums, i, pos);
      }
    }
  }

  /**
   * same will go like permutation
   * but pos when becomes equal to k-1 print and break;
   */
  public void numPermutationOfKSize(int[] nums,int pos,int k){
    for(int i=pos;i<nums.length;i++){
      if(pos==k-1){
        for(int j=0;j<k;j++){
          System.out.print(nums[j]+" ");
        }
        System.out.println();
      }
      else {
        CodeUtil.swap(nums, i, pos);
        numPermutationOfKSize(nums, pos + 1,k);
        CodeUtil.swap(nums, i, pos);
      }
    }
  }

  /**
   * input : {1,2,3}
   *
   * returns all combination of every possible length
   * output:
   * 1
   * 1 2
   * 1 2 3
   * 1 3
   * 1 3 2
   * 2
   * 2 1
   * 2 1 3
   * 2 3
   * 2 3 1
   * 3
   * 3 2
   * 3 2 1
   * 3 1
   * 3 1 2
   */

  /**
   * for all permutation, hence no need to size check
   * so, after swap just print array as it is.
   */
  public void numAllPermutation(int[] nums,int pos){
    for(int i=pos;i<nums.length;i++){
      CodeUtil.swap(nums, i, pos);
      for(int k=0;k<=pos;k++){
        System.out.print(nums[k]+" ");
      }
      System.out.println();
      numAllPermutation(nums, pos + 1);
      CodeUtil.swap(nums, i, pos);
      }
  }

  /**
   * 1 2 3
   *
   * 1        1
   *
   */

  public void temp(int arr[],int pos, int k,String prefix){
    if(k==0){
      System.out.println(prefix);
      return;
    }
    for(int i=0;i<arr.length;i++){
      if(arr[i]!=arr[pos]) {
        String newPrefix = prefix + arr[i];
        temp(arr, pos + 1, k - 1, newPrefix);
      }
    }
  }

  public static void main(String[] args) {
    int[] arr={1,2,3,4};
    ArrayPermutation per= new ArrayPermutation();
    //per.numAllPermutation(arr,0);
   // per.numPermutationOfKSize(arr,0,4);
    //per.numPermutation(arr,0);
    per.temp(arr,0,3,"");
  }
}