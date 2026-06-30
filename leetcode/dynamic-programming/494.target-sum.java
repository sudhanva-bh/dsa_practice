/*
 * @lc app=leetcode id=494 lang=java
 *
 * [494] Target Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums) sum += i;

        if(sum < Math.abs(target)) return 0;

        int tar = sum + target;

        if(tar % 2 != 0) return 0;
        tar /= 2;

        int[] dp = new int[tar + 1];
        dp[0] = 1;

        for(int i : nums) {
            for(int s = tar; s >= i; s--) {
                dp[s] += dp[s - i];
            }
        }

        return dp[tar];
    }
}
// @lc code=end

