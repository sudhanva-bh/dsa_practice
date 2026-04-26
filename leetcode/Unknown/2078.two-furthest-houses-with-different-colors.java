/*
 * @lc app=leetcode id=2078 lang=java
 *
 * [2078] Two Furthest Houses With Different Colors
 */

// @lc code=start
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length, max = 0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = n - 1; j > i; j--) {
                if(colors[i] != colors[j]) {
                    max = Math.max(max, j - i);
                    break;
                }
            }
        }

        return max;
    }
}
// @lc code=end

