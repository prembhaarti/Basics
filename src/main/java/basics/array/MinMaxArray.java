package basics.array;

import java.util.Arrays;

public class MinMaxArray {

  /**
   * get max element last seen from right
   *
   * O(n)
   *
   * start from right
   * take max= min_value
   *
   * if element is greater than update max and basics.array place
   * else put max in basics.array place
   * @param arr
   * @return
   */
    public static int[] makeMaxArray(int[] arr){
      int maxArray[] = Arrays.copyOf(arr, arr.length); // don't want to change original basics.array

      int max=Integer.MIN_VALUE;
      for(int i=maxArray.length-1;i>=0;i--){
        if (maxArray[i] > max) {
          max=maxArray[i];
        }
        else {
          maxArray[i]=max;
        }
      }
      return maxArray;
    }

  public static int[] makeMinArray(int[] arr){
    int minArray[] = Arrays.copyOf(arr, arr.length); // don't want to change original basics.array


    int min=Integer.MAX_VALUE;
    for(int i=0;i<arr.length;i++){
      if(minArray[i]< min){
        min=minArray[i];
      }
      else{
        minArray[i]=min;
      }
    }
    return minArray;
  }

  public static int[] makeMinFromRight(int[] arr){
    int minArray[] = Arrays.copyOf(arr, arr.length); // don't want to change original basics.array


    int min=Integer.MAX_VALUE;
    for(int i=arr.length-1;i>=0;i--){
      if(minArray[i]< min){
        min=minArray[i];
      }
      else{
        minArray[i]=min;
      }
    }
    return minArray;
  }


  public static void main(String[] args) {
    int[] arr = {3, 15, 2, 12, 4, 6, 9, 0};
//    int[] maxArray=MinMaxArray.makeMaxArray(arr);
    int[] minArray=MinMaxArray.makeMinArray(arr);
//    MinMaxArray.display(maxArray);
    MinMaxArray.display(minArray);
  }

  private static void display(int[] arr){
    System.out.println();
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+"| ");
    }
  }

}