package array;

import java.util.Arrays;

/**
 * find triplet in the array having pythagorus relation
 * a^2 = b^2+c^2
 * i.e. 3^2 + 4^2 = 5^2 => 9+16=25
 *
 * {1,2,3,6,5,6,4,8,9}
 * {1,2,3,4,4,5,6,8,9}
 *
 * {1,4,9,16,16,36,64,81}
 *  i              j, last
 *
 *  arr[i]^2 + arr[j]^2 = arr[last]^2
 *  search for 81 as in 1 to 64 as sliding window
 *
 *  keep decreasing last until found
 *  j=last-1;
 *
 */
public class Triplet {

  public void findTriplet(int[] arr){
    // if size is less than 3 then it's not eligible
    if(arr.length<3){
      return;
    }
    Arrays.sort(arr);
    int sqr[] = new int[arr.length];
    // storing square of arr into sqr array
    for(int i=0;i<arr.length;i++){
      sqr[i]=arr[i]*arr[i];
    }
    for(int last=sqr.length-1;last>=2;last--){
      int i=0;
      int j=last-1;
      while(i<j){
        int lhs=sqr[i]+sqr[j];
        if(lhs==sqr[last]){
          System.out.println(arr[i]+","+arr[j]+","+arr[last]);break;
        }
        else if(lhs<sqr[last]) {
          i++;
        }
        else j--;
      }
    }

  }

  public static void main(String[] args) {
    int[] arr={1,2,3,6,5,6,4,8,9};
    Triplet triplet= new Triplet();
    triplet.findTriplet(arr);
  }
}