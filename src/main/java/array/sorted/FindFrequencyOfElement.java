package array.sorted;

public class FindFrequencyOfElement {

    static int[] arr={1, 1, 2, 2, 2, 2, 3};

    /**
     * find freq of 2 -> i.e 4
     *
     * find first index of 2 -> 2
     * find last index of 2 -> 5
     * last index - first index + 1 -> 5-2+1 -> 4
     */

    public static int findFrequency(int arr[], int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int indexFirst= findFirst(arr,num);
        int indexLast = findLast(arr, num);
        if (indexFirst == -1 || indexLast == -1) {
            return -1;
        }
        return indexLast-indexFirst+1;
    }

    public static int findFirst(int arr[], int num) {
        int index=-1;
        int low=0;
        int high=arr.length-1;

        while (low <= high) {
            int mid=low+(high-low)/2;
            if(arr[mid]==num && (mid==0||arr[mid-1]<num)){
                index= mid;break;
            } else if (arr[mid] < num) {
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return index;
    }
    public static int findLast(int arr[], int num) {
        int index=-1;
        int low=0;
        int high=arr.length-1;

        while (low <= high) {
            int mid=low+(high-low)/2;
            if(arr[mid]==num && (mid==arr.length-1||arr[mid+1]>num)){
                index= mid;break;
            } else if (arr[mid] > num) {
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(findFrequency(arr,2));
    }
}