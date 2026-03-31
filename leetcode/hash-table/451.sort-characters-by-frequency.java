/*
 * @lc app=leetcode id=451 lang=java
 *
 * [451] Sort Characters By Frequency
 */

// @lc code=start
class Solution {

    public String frequencySort(String s) {
        int[] map = new int[75];
        int max = 0;
        for (char c : s.toCharArray()) {
            map[c - '0']++;
        }
        for (int i : map) {
            max = Math.max(max, i);
        }
        StringBuilder sb = new StringBuilder(s.length());
        for (int i = max; i >= 1; i--) {
            for (int j = 0; j < 75; j++) {
                if (map[j] == i) {
                    for (int k = 0; k < map[j]; k++) {
                        sb.append((char) ('0' + j));
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.frequencySort("tree"));
    }
}
// @lc code=end

