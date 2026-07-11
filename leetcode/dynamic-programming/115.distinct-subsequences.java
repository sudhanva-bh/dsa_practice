/*
 * @lc app=leetcode id=115 lang=java
 *
 * [115] Distinct Subsequences
 */

// @lc code=start
import java.util.*;

class Solution {
    public int numDistinct(String ss, String t) {
        if (ss.length() < t.length())
            return 0;

        char[] big = ss.toCharArray();
        char[] small = t.toCharArray();

        int[][] dp = new int[big.length + 1][small.length + 1];

        for (int s = 0; s < small.length; s++) {
            dp[big.length][s] = 0;
        }

        for (int b = 0; b < big.length; b++) {
            dp[b][small.length] = 1;
        }

        for (int b = big.length - 1; b >= 0; b--) {
            for (int s = small.length - 1; s >= 0; s--) {
                dp[b][s] += dp[b + 1][s];

                if (big[b] == small[s])
                    dp[b][s] += dp[b + 1][s + 1];
            }
        }

        return dp[0][0];
    }

    int rec(char[] big, char[] small, int b, int s) {
        if (s == small.length) {
            return 1;
        }

        if (b == big.length) {
            return 0;
        }

        if (dp[b][s] != -1) {
            return dp[b][s];
        }

        int ways = 0;

        // dont take
        ways += rec(big, small, b + 1, s);

        // take
        if (big[b] == small[s])
            ways += rec(big, small, b + 1, s + 1);

        dp[b][s] = ways;
        return ways;
    }
}
// @lc code=end
