package array.sorted;

public class SortedRotatedArray {

    /**
     * arr -> {3,4,5,6,7,8,9,1,2}
     * num -> 8
     *
     * get mid -> if num at arr[mid] return mid
     * check if left side sorted -> arr[low]>arr[mid]
     *      if num in sorted range -> num>arr[low] and num<arr[mid]
     *          do binary search by high->mid-1
     *      else pass right side mid+1,high
     * otherwise right side must be sorted
     *      if num in sorted range
     *          do binary search by mid+1,high
     *      else pass left side low,mid-1
     */
    public static int findElement(int[] arr,int low, int high,int num){
        int index=-1;
        if(arr==null||arr.length<1 || low>high){
            return -1;
        }

        int mid=low+(high-low)/2;

        if(num==arr[mid]) return mid;
        if(arr[low]<arr[mid]){
            if(num<arr[mid] && num>=arr[low]){
              index=  findElement(arr,low,mid-1,num);
            }
            else{
               index= findElement(arr,mid+1,high,num);
            }
        }
        else {
            if (num > arr[mid] && num <= arr[high]) {
               index= findElement(arr, mid+1, high, num);
            }
            else{
               index= findElement(arr, low, mid-1, num);
            }
        }
        return index;
    }

    /**
     *
     * if initially arr[low]<=arr[high] -> return 0 that's pivot
     *
     * if reach at mid->0/size or mid element is greater than next return mid
     *
     * if mid element is greater than low -> return mid+1
     *
     */
    public static int findPivot(int[] arr) {
        int low=0;
        int high=arr.length-1;
        if (arr[low] <= arr[high]) {
            return 0;
        }
        int pivot=-1;
        while (low < high) {
            int mid=(low+high)/2;
            if(mid==0||mid==arr.length-1||arr[mid]>arr[mid+1]){
                pivot=mid;
                break;
            }
            else if (arr[mid] >= arr[low]) {
                    low=mid+1;
            }
            else{
                    high=mid-1;
            }
        }
        return pivot;
    }

    /**
     * middle element should be greater than previous as well as next.
     *
     */
    public static int findPivotIncreasingDecreasing(int[] arr) {
        int low=0;
        int high=arr.length-1;
        int pivot=-1;
        while (low < high) {
            int mid=(low+high)/2;
            if(mid==0||mid==arr.length-1||arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                pivot=mid;
                break;
            }
            else if (arr[mid] > arr[low]) {
                low=mid;
            }
            else{
                high=mid;
            }
        }
        return pivot;
    }

    public static void main(String[] args) {
//        int[] arr= new int[]{3,4,5,6,7,8,9,1,2};
        int[] arr= new int[]{1,2,3,4,5,6,7};
        for (int i=0;i<arr.length;i++) {
            int index=findElement(arr,0,arr.length-1,arr[i]);
            int pivot = findPivotIncreasingDecreasing(arr);
            System.out.println(pivot);
        }
    }
}