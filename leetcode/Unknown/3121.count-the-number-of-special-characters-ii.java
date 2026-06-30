/*
 * @lc app=leetcode id=3121 lang=java
 *
 * [3121] Count the Number of Special Characters II
 */

// @lc code=start
class Solution {
    public int numberOfSpecialChars(String word) {
        int n = word.length();
        int[] firstUpperOccurance = new int[26];
        int[] lastLowerOccurance = new int[26];

        char[] ca = word.toCharArray();
        char c;

        for (int i = 0; i < n; i++) {
            c = ca[i];

            if (c >= 'A' && c <= 'Z') {
                if (firstUpperOccurance[c - 'A'] == 0)
                    firstUpperOccurance[c - 'A'] = i + 1;
            } else
                lastLowerOccurance[c - 'a'] = i + 1;
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (firstUpperOccurance[i] != 0 && lastLowerOccurance[i] != 0
                    && firstUpperOccurance[i] > lastLowerOccurance[i])
                count++;
        }

        return count;
    }
}
// @lc code=end
