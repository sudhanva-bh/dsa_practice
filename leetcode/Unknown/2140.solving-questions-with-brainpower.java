/*
 * @lc app=leetcode id=2140 lang=java
 *
 * [2140] Solving Questions With Brainpower
 */

// @lc code=start
import java.util.*;

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length, nextIndex;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];

        for (int i = n - 2; i >= 0; i--) {
            nextIndex = i + questions[i][1] + 1;

            long take = questions[i][0];

            if (nextIndex < n) {
                take += dp[nextIndex];
            }

            dp[i] = Math.max(take, dp[i + 1]);
        }

        return dp[0];
    }
}
// @lc code=end
