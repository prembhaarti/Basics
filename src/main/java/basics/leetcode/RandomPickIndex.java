package basics.leetcode;

import java.util.Random;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : RandomPickIndex
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class RandomPickIndex {
    /**
     * 398. Random Pick Index
     * Given an array of integers with possible duplicates, randomly output the index of a given target
     * number. You can assume that the given target number must exist in the array.

     Note:
     The array size can be very large. Solution that uses too much extra space will not pass the judge.

     Example:

     int[] nums = new int[] {1,2,3,3,3};
     Solution solution = new Solution(nums);

     // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
     solution.pick(3);

     // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
     solution.pick(1);

     time : O(n);
     * @param nums
     */

    private int[] nums;
    Random rmd;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        rmd = new Random();
    }

    public int pick(int target) {
        int res = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) continue;
            if (rmd.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
