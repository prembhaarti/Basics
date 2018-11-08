package basics.array;

import java.util.HashMap;
import java.util.Map;

public class DistinctElementUnderWindow {

    /**
     * find distinct element under window size k=4
     *
     * {1, 2, 1, 3, 4, 2, 3}
     *
     * output:
     * [1, 2, 3]
     * [1, 2, 3, 4]
     * [1, 2, 3, 4]
     * [2, 3, 4]
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * create map and put k elements first. [key (num) -> value (count)]
     *
     * remove k behind element from map from ith position
     *      if count==1 then remove else decrement count
     * add element at ith position if element exist increase count else add with 1
     * print keyset and increment i until basics.array end.
     *
     */
    public static void distinctElementUnderWindowK(int arr[], int k) {
        if (k > arr.length) {
            return;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int i=0;
        while(i<k) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else {
                map.put(arr[i],1);
            }
            i++;
        }
        System.out.println(map.keySet());
        while (i < arr.length) {
            if(map.get(arr[i-k])==1){
                map.remove(arr[i-k]);
            }
            else{
                map.put(arr[i-k],map.get(arr[i-k])-1);
            }
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else {
                map.put(arr[i],1);
            }
            i++;
            System.out.println(map.keySet());
        }
    }

    public static void main(String[] args) {
        int arr[]={1, 2, 1, 3, 4, 2, 3};
        distinctElementUnderWindowK(arr,4);
    }
}
