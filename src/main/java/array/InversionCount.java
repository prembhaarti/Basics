package array;

import java.util.Arrays;

public class InversionCount {

  /**
   *
   * divide array into two half -> low:mid and mid+1:high
   * send each to mergeSort recursively one by one until size becomes 1.
   *
   * then start to merge from single element to whole array.
   *
   * count inversion from merge and add previous inversion from mergeSort
   */
  public int mergeSort(int[] array, int low, int high){
    int count=0;
    if(low<high){
      int mid= (low+high)/2;
      count=mergeSort(array,low,mid);
      count+=mergeSort(array,mid+1,high);
      count+=merge(array,low,high);
    }
    return count;
  }

  /**
   * take two half of array from low:mid and mid+1:high
   *
   * start to merge.
   * when elements taken from right array means
   *     no. of elements in left array from i to mid+1 position
   *     are greater than element on right array and hence need inversion
   * return inversion count
   */
  public int merge(int[] array,int low, int high){
    int inversion=0;
    int middle=(low+high)/2;
    int i=low;
    int j=middle+1;
    int k=0;
    int temp[] = new int[high-low+1];

    while(i<=middle && j<=high){
      if(array[i]<array[j]){
        temp[k++]=array[i++];
      }
      else{
        inversion+=middle+1-i;  //tricky part-
                                //no. of elements in left array from i to mid+1 position
                                // are greater than element on right array and hence need inversion
        temp[k++]=array[j++];
      }
    }
    while(i<=middle){
      temp[k++]=array[i++];
    }
    while(j<=high){ temp[k++]=array[j++];}

    for(k=0;k<temp.length;k++){
      array[low++]=temp[k];
    }
    return inversion;
  }
  public static void main(String[] args) {
    InversionCount ic= new InversionCount();
    //int[] array= new int[]{1,9,4,3,8,6};
    int[] array= new int[]{5,1,6,2,3};
//    int[] array= new int[]{2,4,1,3,5};
    //int[] array= new int[]{3,9,1,8,4,5,0};
    System.out.println(ic.mergeSort(array,0,array.length-1));
    System.out.println(Arrays.toString(array));
    //System.out.println(count);
  }

}
