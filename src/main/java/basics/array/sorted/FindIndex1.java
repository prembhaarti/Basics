package basics.array.sorted;

public class FindIndex1 {
    static int arr[]={0, 0, 0, 0, 0, 0, 1, 1, 1, 1};

    //if first element is 1
    //find mid check each time if arr[mid-1] is 0 and arr[mid] is 1

    public static int findFirst1Index(int arr[]) {
        int low=0;
        int high=arr.length-1;
        int index=-1;

        while(low<=high) {
            int mid = low+(high-low)/2;
            if(arr[mid]==1 && (mid==0||arr[mid-1]==0)){
                index= mid;
                break;
            }
            else if(arr[mid]==0){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return index;
    }


    public static void main(String[] args) {
        System.out.println(findFirst1Index(arr));
    }
}
