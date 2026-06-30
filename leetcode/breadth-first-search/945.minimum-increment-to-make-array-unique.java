/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start
import java.util.*;

class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));

        int currHigh = -1;
        int incs = 0;

        for (int i = 0; i < nums.length; i++) {
            // System.out.printf("i: %d, currHigh: %d, incs: %d\n", i, currHigh, incs);
            currHigh = Math.max(currHigh + 1, nums[i]);
            incs += currHigh - nums[i];
        }

        return incs;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 2, 1, 7 };
        // System.out.println(new Solution().minIncrementForUnique(nums));
    }
}
// @lc code=end

// [1, 1, 2, 2, 3, 7]
// [1, 2, 3, 4, 5, 7]
//