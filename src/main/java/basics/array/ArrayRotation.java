package basics.array;

import java.util.Arrays;

public class ArrayRotation {

    static int arr[] = {1,2,3,4,5,6,7,8};

    /**
     * rotating arr by k times.
     * 1. reverse 0 to k-1 from basics.array
     * 2. reverse k to end of arr
     * 3. reverse all basics.array.
     *
     * :: O(n)
     */
    public static void rotateByK(int[] arr,int k) {
        reverse(arr,0,k-1);
        reverse(arr,k,arr.length-1);
        reverse(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr,int start, int end){
        for(int i=start,j=end;i<j;i++,j--) {
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
    }

    public static void main(String[] args) {
        rotateByK(arr,4);
    }
}
