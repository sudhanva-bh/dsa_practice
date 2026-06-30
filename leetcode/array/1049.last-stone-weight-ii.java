/*
 * @lc app=leetcode id=1049 lang=java
 *
 * [1049] Last Stone Weight II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;

        for (int i : stones)
            sum += i;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int i : stones) {
            for (int s = sum; s >= i; s--) {
                dp[s] |= dp[s - i];
            }
        }

        for (int s = sum / 2; s >= 0; s--) {
            if (dp[s]) {
                return sum - (2 * s);
            }
        }

        return 0;
    }
}
// @lc code=end
