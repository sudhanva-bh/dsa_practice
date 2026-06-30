/*
 * @lc app=leetcode id=140 lang=java
 *
 * [140] Word Break II
 */

// @lc code=start
import java.util.*;

class Solution {
    List<String>[] dp;
    List<String> empty = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = (List<String>[]) new List[s.length() + 1];
        return rec(s, 0, wordDict);
    }

    List<String> rec(String s, int index, List<String> dict) {
        if (index == s.length()) {
            return null;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        List<String> curr = new ArrayList<>();
        for (String i : dict) {
            if (s.startsWith(i, index)) {
                List<String> next = rec(s, index + i.length(), dict);
                if (next == null)
                    curr.add(i);
                else if (next.size() != 0) {

                    for (String j : next) {
                        curr.add(i + " " + j);
                    }

                }
            }
        }

        dp[index] = curr;
        return curr;
    }
}
// @lc code=end
