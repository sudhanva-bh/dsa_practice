

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] hm = new boolean[128];
        int max = 0;

        int r = 0, l = 0, n = s.length();
        char[] ca = s.toCharArray();

        while (l < n) {
            if (hm[ca[l]]) {
                while (ca[r] != ca[l]) {
                    hm[ca[r]] = false;
                    r++;
                }
                hm[ca[r]] = false;
                r++;
            }

            hm[ca[l]] = true;
            max = Math.max(max, l - r + 1);
            l++;
        }

        return max;
    }
}
// @lc code=end

