package array.sorted;

public class FloorAndCeil {

  /**
   *
   * floor finding mean if num exist in array print
   * else find lower value exists in array
   *
   * first check boundary condition:
   * if num<arr[0] -> floor doesn't exist
   * if num>arr[size] -> last element of an array is the floor
   *
   * otherwise do binary search
   * if num== mid print mid
   * if num is greater than previous(mid-1) and less than mid -> print mid-1
   *
   * num> mid -> high=mid-1
   * num<mid -> low = mid+1
   *
   */
  public int getFloor(int num,int[] arr,int low, int high){
    int floorIndex=-1;
    if(num>arr[arr.length-1])return arr[arr.length-1];
    if(num<arr[0]) return -1;
    while(low<=high) {
      int mid = (low + high) / 2;
      if(arr[mid]==num){
        floorIndex= arr[mid]; break;
      }
      else if (num>arr[mid - 1] && num < arr[mid]) {
        floorIndex = arr[mid-1]; break;
      }
      if (arr[mid] > num) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return  floorIndex;
  }

  public int getCeil(int num,int[] arr,int low, int high){
    int floorIndex=-1;
    if(num>arr[arr.length-1])return -1;
    if(num<arr[0]) return arr[0];
    while(low<=high) {
      int mid = (low + high) / 2;
      if (num==arr[mid]||(num>arr[mid - 1] && num < arr[mid])) {
        if(arr[mid]==num) floorIndex= arr[mid];
        else {
          floorIndex = arr[mid];
        }
        break;
      }
      if (arr[mid] > num) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return  floorIndex;
  }


  public static void main(String[] args) {
    FloorAndCeil fc= new FloorAndCeil();
    int input[] = {1,2,5,6,11,15};
    for(int i=0;i<17;i++) {
      System.out.println(i+":"+fc.getCeil(i, input, 0, input.length));
    }
  }
}