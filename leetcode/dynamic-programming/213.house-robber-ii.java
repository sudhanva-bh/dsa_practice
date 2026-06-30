/*
 * @lc app=leetcode id=213 lang=java
 *
 * [213] House Robber II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        return Math.max(robLinear(nums, 0, n - 2), robLinear(nums, 1, n - 1));
    }

    int robLinear(int[] nums, int start, int end) {
        if (start == end)
            return nums[start];

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start], nums[start + 1]);
        int curr;

        for (int i = start + 2; i <= end; i++) {
            curr = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
// @lc code=end
