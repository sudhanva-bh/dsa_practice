/*
 * @lc app=leetcode id=137 lang=java
 *
 * [137] Single Number II
 */

// @lc code=start
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            int mask = (1 << i);
            for(int j : nums) {
                if((j & mask) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0) {
                res |= mask;
            } 
        }
        return res;
    }
}
// @lc code=end

