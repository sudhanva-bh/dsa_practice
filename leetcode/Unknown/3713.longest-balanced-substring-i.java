/*
 * @lc app=leetcode id=3713 lang=java
 *
 * [3713] Longest Balanced Substring I
 */

// @lc code=start
import java.util.*;

class Solution {
    boolean check(int[] nums, int max) {
        for(int i : nums) {
            if(i != 0 && i != max) return false;
        }

        return true;
    }

    public int longestBalanced(String s) {
        int n = s.length();
        int maxLen = 0;
        char[] ca = s.toCharArray();

        for(int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int max = 0;

            for(int j = i; j < n; j++) {
                max = Math.max(max, ++freq[ca[j] - 'a']);

                if(check(freq, max)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}
// @lc code=end

