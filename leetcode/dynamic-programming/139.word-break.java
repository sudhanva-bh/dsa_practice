/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
import java.util.*;

class Solution {
    short[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new short[s.length() + 1];
        return rec(0, s, wordDict);
    }

    boolean rec(int index, String s, List<String> wordDict) {
        if(index == s.length()) return true;

        if(dp[index] != 0) {
            return dp[index] == 1;
        }

        for(String t : wordDict) {
            if(s.startsWith(t, index) && rec(index + t.length(), s, wordDict)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = -1;
        return false;
    }
}
// @lc code=end

