/*
 * @lc app=leetcode id=191 lang=java
 *
 * [191] Number of 1 Bits
 */

// @lc code=start
class Solution {

    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            weight += n & 1;
            n = n >> 1;
        }
        return weight;
    }
}
// @lc code=end

14 : 0000
     0001
