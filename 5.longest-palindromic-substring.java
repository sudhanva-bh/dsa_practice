/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {

    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        char[] sc = s.toCharArray();
        int center = 0, offset, maxStart = 0, maxLength = 0, n = sc.length;
        while (center < n) {
            if (center < n - 1 && sc[center] == sc[center + 1]) {
                offset = 0;
                while (center - offset >= 0 && center + 1 + offset < n && sc[center - offset] == sc[center + 1 + offset]) {
                    offset++;
                }
                if (2 * offset + 2 > maxLength) {
                    maxStart = center - offset;
                    maxLength = 2 * offset + 2;
                }
            }
            offset = 0;
            while (center - offset >= 0 && center + offset < n && sc[center - offset] == sc[center + offset]) {
                offset++;
            }
            if (2 * offset + 1 > maxLength) {
                maxStart = center - offset;
                maxLength = 2 * offset + 1;
            }
            center++;
        }
        return s.substring(maxStart + 1, maxStart + maxLength - 1);
    }
}
// @lc code=end

