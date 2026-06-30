/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
import java.util.*;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;

        if ((sum & 1) == 1)
            return false;
        sum /= 2;

        int n = nums.length;

        boolean[] dp = new boolean[sum + 1];

        dp[0] = true;

        for(int i : nums) {
            for(int s = sum; s >= i; s--) {
                dp[s] = dp[s] || dp[s - i];
            }
        }

        return dp[sum];
    }
}
// @lc code=end
