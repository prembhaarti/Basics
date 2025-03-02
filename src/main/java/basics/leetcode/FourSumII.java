package basics.leetcode;

import java.util.HashMap;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : FourSumII
 * Creator : Edward
 * Date : Nov, 2017
 * Description : 454. 4Sum II
 */
public class FourSumII {
    /**
     * Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l)
     * there are such that A[i] + B[j] + C[k] + D[l] is zero.

     To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500.
     All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.

     Example:

     Input:
     A = [ 1, 2]
     B = [-2,-1]
     C = [-1, 2]
     D = [ 0, 2]

     Output:
     2

     Explanation:
     The two tuples are:
     1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
     2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0

     time : O(n^2)
     space : O(n)

     space : ON^2???
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int a : A) {
            for (int b : B) {
                int sum = a + b;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        for (int c : C) {
            for (int d : D) {
                int sum = -c - d;
                res += map.getOrDefault(sum, 0);
            }
        }
        return res;
    }
}
