package basics.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FourElementSum {

    public static void main(String[] args) {
        int arr[] ={1, 5, 1, 0, 6, 0};
        getPairSum(arr,7);
    }

    public static void getPairSum(int[] arr, int sum) {
        if (arr.length < 4) {
            return;
        }
        List<PairSum> sumArray = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sumArray.add(new PairSum(arr[i], arr[j], arr[i] + arr[j]));
            }
        }
        Collections.sort(sumArray);

        int start = 0;
        int end = sumArray.size() - 1;

        while (start < end) {
            if (sumArray.get(start).sum + sumArray.get(end).sum < sum) {
                start++;
            } else if (sumArray.get(start).sum + sumArray.get(end).sum > sum) {
                end--;
            } else if ((sumArray.get(start).sum + sumArray.get(end).sum) == sum
                    && !common(sumArray.get(start), sumArray.get(end))) {
                System.out.println(sumArray.get(start).a + "," + sumArray.get(start).b
                        + "," + sumArray.get(end).a + "," + sumArray.get(end).b);
                break;
            }
        }
    }

    public static boolean common(PairSum first, PairSum second) {
        return first.a==second.a || first.b==second.b || first.a==second.a || first.b==second.a ;
    }
}


class PairSum implements Comparable<PairSum>{
    int a;
    int b;
    int sum;

    public PairSum(int a, int b, int sum) {
        this.a = a;
        this.b = b;
        this.sum = sum;
    }

    @Override
    public int compareTo(PairSum o) {
        return this.sum-o.sum;
    }
}