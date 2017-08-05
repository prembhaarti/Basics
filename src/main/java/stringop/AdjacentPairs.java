package stringop;

import static util.CodeUtil.swap;

import java.util.HashMap;
import java.util.Map;

public class AdjacentPairs {
  public static void main(String[] args) {
    Map<Integer, Integer> pairs = new HashMap<>();
    int[] arr = {3, 5, 6, 4, 1, 2};
    pairs.put(1, 3);
    pairs.put(2, 6);
    pairs.put(4, 5);
    pairs.put(3, 1);
    pairs.put(6, 2);
    pairs.put(5, 4);

    int count = makeArrayAdjacent(arr, pairs, 0);
    System.out.println(count);
    System.out.println(arr);
  }

  private static int makeArrayAdjacent(int[] arr, Map<Integer, Integer> pairs, int i) {
    if (i >= arr.length - 1) {
      return 0;
    }

    int[] copyArr = arr.clone();
    if (pairs.get(arr[i]) == arr[i + 1])
      return makeArrayAdjacent(arr, pairs, i + 2);

    int index = getIndex(pairs.get(arr[i]), arr);
    swap(arr, index, i + 1);
    int a = makeArrayAdjacent(arr, pairs, i + 2);

    //swap(arr, i + 1, index);
    index = getIndex(pairs.get(copyArr[i + 1]), copyArr);
    swap(copyArr, index, i);
    int b = makeArrayAdjacent(copyArr, pairs, i + 2);
    return 1 + Math.min(a, b);
  }

  private static int getIndex(Integer integer, int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == integer)
        return i;
    }
    return -1;
  }
}
