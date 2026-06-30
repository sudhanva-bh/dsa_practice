/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        rec(nums, target, 0);
        return count;
    }

    void rec(int[] nums, int target, int curr) {
        if(curr == nums.length) {
            if(target == 0) count++;
            return;
        }

        rec(nums, target + nums[curr], curr + 1);
        rec(nums, target - nums[curr], curr + 1);
    }
}
// @lc code=end

