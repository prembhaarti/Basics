package basics.array;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSumZero {

    public static int largestSubArrayWithSumZero(int[] inputArray) {
        int maxlen=0,sum =0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inputArray.length; i++) {
            sum = sum + inputArray[i];
            if (inputArray[i]==0 && maxlen==0)
                maxlen =1;

            if (sum==0)
                maxlen = i+1;

            Integer prev = map.get(sum);
            if (prev!=null){
                maxlen = Math.max(maxlen,i-prev);
            }else {
                map.put(sum,i);
            }
        }
        return maxlen;
    }

    public static void main(String[] args) {
        int[] arr={1,3,14,-8,-6};
        System.out.println(largestSubArrayWithSumZero(arr));

    }

}
