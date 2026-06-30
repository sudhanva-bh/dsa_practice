/*
 * @lc app=leetcode id=3120 lang=java
 *
 * [3120] Count the Number of Special Characters I
 */

// @lc code=start
class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] capital = new boolean[26];
        boolean[] small = new boolean[26];

        char[] ca = word.toCharArray();

        int n = word.length();

        for(char c : ca) {
            if(c >= 'a' && c <= 'z') {
                small[c - 'a'] = true;
            } else {
                capital[c - 'A'] = true;
            }
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {
            if(capital[i] && small[i]) count++;
        }

        return count;
    }
}
// @lc code=end

