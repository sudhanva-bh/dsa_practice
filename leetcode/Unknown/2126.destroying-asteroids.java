/*
 * @lc app=leetcode id=2126 lang=java
 *
 * [2126] Destroying Asteroids
 */

// @lc code=start
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        int[] fq = new int[100001];

        for(int i : asteroids) {
            fq[i]++;
        }

        long sum = mass;

        for(int i = 1; i <= 100001; i++) {
            if(fq[i] > 0) {
                if(sum < i) return false;
                sum += (long)fq[i] * i;
            }
        }

        return true;
    }
}
// @lc code=end

