package array.sorted;

public class ClosestPair {

    /**
     * find closed pair from two sorted array having sum close to given num
     *          low
     * arr1 -> {1, 4, 5, 7}
     * arr2 -> {10, 20, 30, 40}
     * sum -> 32            high
     *
     * take diff -> max
     * abs(low+high-num)<diff then update diff
     * low+high>num, high--
     * low+high<num, low--
     * low+high==num, break; least diff found
     */
    public static void closestPair(int[] arr1, int[] arr2,int num){
        int diff=Integer.MAX_VALUE;
        int elementA=-1;
        int elementB=-1;
        int arr1Low=0;
        int arr2High=arr2.length-1;

        while(arr1Low<arr1.length && arr2High>=0){
            if(Math.abs(arr1[arr1Low]+arr2[arr2High] - num) <diff){
                diff=Math.abs(arr1[arr1Low]+arr2[arr2High]-num);
                elementA=arr1[arr1Low];
                elementB=arr2[arr2High];
            }
            if (arr1[arr1Low] + arr2[arr2High] < num) {
                arr1Low++;
            }
            else if(arr1[arr1Low] + arr2[arr2High] > num){
                arr2High--;
            }
            else {
                break;
            }
        }
        System.out.println(elementA);
        System.out.println(elementB);
    }

    public static void main(String[] args) {
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        closestPair(ar1,ar2,32);
    }
}
